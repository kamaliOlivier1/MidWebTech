package MODEL;

import MODEL.Course;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_definition_id")
    private UUID courseDefinitionId;

    @Column(name = "course_definition_code")
    private String courseDefinitionCode;

    @Column(name = "course_definition_description")
    private String courseDefinitionDescription;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    public CourseDefinition() {
    }

    public UUID getCourseDefinitionId() {
      return courseDefinitionId;
    }

    public void setCourseDefinitionId(UUID courseDefinitionId) {
      this.courseDefinitionId = courseDefinitionId;
    }

    public String getCourseDefinitionCode() {
      return courseDefinitionCode;
    }

    public void setCourseDefinitionCode(String courseDefinitionCode) {
      this.courseDefinitionCode = courseDefinitionCode;
    }

    public String getCourseDefinitionDescription() {
      return courseDefinitionDescription;
    }

    public void setCourseDefinitionDescription(String courseDefinitionDescription) {
      this.courseDefinitionDescription = courseDefinitionDescription;
    }

    public Course getCourse() {
      return course;
    }

    public void setCourse(Course course) {
      this.course = course;
    }
}