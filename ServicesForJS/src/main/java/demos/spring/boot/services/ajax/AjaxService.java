package demos.spring.boot.services.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

@RestController
public class AjaxService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
    public String hello() {
        return "Hello from the server";
    }

    @RequestMapping(value = "/states", method = RequestMethod.GET, produces = "text/html")
    public void slowHello(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Headers are sent now, committing the request
        flushAndSleep(out);
        //Send some content with lots of pauses...
        sendDataSlowly(out);
    }

    @RequestMapping(value = "/headers", method = RequestMethod.GET, produces = "text/html")
    public void helloWithHeaders(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("foo", "Fred");
        response.setHeader("bar", "Wilma");
        response.setHeader("zed", "Dino");
        PrintWriter out = response.getWriter();
        out.println("<b>Hello from the server!</b>");
    }

    @RequestMapping(value = "/postingData", method = RequestMethod.POST, produces = "text/plain")
    public String postingData(@RequestParam("no1") int no1, @RequestParam("no2") int no2) throws Exception {
        return String.valueOf(no1 + no2);
    }

    @RequestMapping(value = "/genXML", method = RequestMethod.GET)
    public void genXML(HttpServletResponse response) throws Exception {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.println("<person title=\"Mr\">");
        out.println("    <forename>Joe</forename>");
        out.println("    <surname>Bloggs</surname>");
        out.println("</person>");
    }

    @RequestMapping(value = "/genJSON", method = RequestMethod.GET)
    public void genJSON(HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{");
        out.println("    \"title\": \"Mr\",");
        out.println("    \"forename\":\"Joe\",");
        out.println("    \"surname\":\"Bloggs\",");
        out.println("}");
    }

    @RequestMapping(value = "/parameters", method = RequestMethod.POST)
    public String returnParameters(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>");
        Enumeration<String> names = request.getParameterNames();
        final String msg = "<li>%s=%s</li>";
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            builder.append(String.format(msg, name, request.getParameter(name)));
        }
        builder.append("</ul>");
        return builder.toString();
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public String makeBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        String center = request.getParameter("center");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String code = request.getParameter("code");

        String msg = "Thank you candidate %s for booking your test in %s at %s on %s";
        return String.format(msg, code, center, time, date);
    }

    private void sendDataSlowly(PrintWriter out) throws IOException {
        String[] data = {"<b>", "Sorry", " for", " the", " delay...", "</b>"};
        for (String d : data) {
            out.println(d);
            flushAndSleep(out);
        }
    }

    private void flushAndSleep(Writer out) throws IOException {
        out.flush();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("Servlet crashed with: " + ex.getMessage());
        }
    }
}
