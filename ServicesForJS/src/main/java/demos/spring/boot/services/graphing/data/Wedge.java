package demos.spring.boot.services.graphing.data;

public class Wedge {
    public Wedge() {
        this("unknown", 0);
    }

    public Wedge(String label, int value) {
        super();
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private String label;
    private int value;
}
