package MODEL;
import MODEL.AcademicUnit;
import MODEL.Semester;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "academic_id", referencedColumnName = "academic_id")
    private AcademicUnit academicUnit;

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    private Semester semester;

    @ManyToMany
    @JoinTable(
        name = "course_teacher",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers = new HashSet<>();

    public Course() {
    }

    public Course(UUID courseId, String courseCode, String courseName, AcademicUnit academicUnit, Semester semester) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.academicUnit = academicUnit;
        this.semester = semester;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}