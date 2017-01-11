package demos.spring.boot.services.graphing.data;

import java.util.ArrayList;

public class PieChart {
    public PieChart() {
        super();
        values = new ArrayList<Wedge>();
    }

    public ArrayList<Wedge> getValues() {
        return values;
    }

    public void setValues(ArrayList<Wedge> values) {
        this.values = values;
    }

    public void addWedge(Wedge wedge) {
        values.add(wedge);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pie chart holding:\n");
        for (Wedge w : values) {
            builder.append(String.format("\t%d of %s\n", w.getValue(), w.getLabel()));
        }
        return builder.toString();
    }

    private ArrayList<Wedge> values;
}
