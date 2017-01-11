package demos.spring.boot.services.flights;

import demos.spring.boot.services.flights.data.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightsService {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Flight> allFlights() {
        return schedule;
    }

    @RequestMapping(value = "/origin/{origin}", method = RequestMethod.GET, produces = "application/json")
    public List<Flight> flightsByOrigin(@PathVariable("origin") String origin) {
        List<Flight> results = new ArrayList<Flight>();
        for (Flight f : schedule) {
            if (f.getOrigin().equals(origin)) {
                results.add(f);
            }
        }
        return results;
    }

    @RequestMapping(value = "/destination/{destination}", method = RequestMethod.GET, produces = "application/json")
    public List<Flight> flightsByDestination(@PathVariable("destination") String destination) {
        List<Flight> results = new ArrayList<Flight>();
        for (Flight f : schedule) {
            if (f.getDestination().equals(destination)) {
                results.add(f);
            }
        }
        return results;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Flight> deleteFlight(@PathVariable("id") int id) {
        Flight found;
        if ((found = removeFlight(id)) != null) {
            return new ResponseEntity<Flight>(found, HttpStatus.OK);
        }
        return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Flight updateFlight(@PathVariable("id") int id, @RequestBody Flight flight) {
        removeFlight(id);
        schedule.add(flight);
        return flight;
    }

    private Flight removeFlight(int id) {
        Iterator<Flight> iter = schedule.iterator();
        while (iter.hasNext()) {
            Flight f = iter.next();
            if (f.getNumber() == id) {
                iter.remove();
                return f;
            }
        }
        return null;
    }

    @Resource(name = "schedule")
    public void setSchedule(List<Flight> schedule) {
        this.schedule = schedule;
    }

    private List<Flight> schedule;
}
