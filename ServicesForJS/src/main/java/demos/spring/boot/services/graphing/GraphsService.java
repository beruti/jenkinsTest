package demos.spring.boot.services.graphing;

import demos.spring.boot.services.graphing.data.PieChart;
import demos.spring.boot.services.graphing.data.Wedge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/graphs")
public class GraphsService {
    @RequestMapping(value = "/barChart", method = RequestMethod.GET, produces = "application/json")
    public FileSystemResource fetchBarChartData() throws IOException {
        return new FileSystemResource(context.getResource("classpath:resources/barChartData.json").getFile());
    }

    @RequestMapping(value = "/pieChart", method = RequestMethod.GET, produces = "application/json")
    public FileSystemResource fetchPieChartData() throws IOException {
        return new FileSystemResource(context.getResource("classpath:resources/pieChartData.json").getFile());
    }

    @RequestMapping(value = "/pieChartDynamic", method = RequestMethod.GET, produces = "application/json")
    public PieChart fetchPieChartData2() throws IOException {
        PieChart chart = new PieChart();
        chart.addWedge(new Wedge("JavaScript", 5));
        chart.addWedge(new Wedge("Java", 8));
        chart.addWedge(new Wedge("Scala", 20));
        chart.addWedge(new Wedge("C#", 12));
        return chart;
    }

    @RequestMapping(value = "/pieChartDynamic", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public PieChart fetchPieChartData2(@RequestBody PieChart chart) throws IOException {
        System.out.println(chart);
        return chart;
    }

    @Autowired
    private ApplicationContext context;
}
