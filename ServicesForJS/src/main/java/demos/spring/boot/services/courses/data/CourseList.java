package demos.spring.boot.services.courses.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CourseList")
public class CourseList {
    public CourseList() {
    }

    public CourseList(List<Course> courses) {
        this.courses = courses;
    }

    @XmlElement(name = "Course")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private List<Course> courses;
}
