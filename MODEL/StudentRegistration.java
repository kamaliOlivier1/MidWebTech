/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "studentRegistration")
public class StudentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registration_id")
    private UUID registrationId;

    @Column(name = "registration_code")
    private String registrationCode;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "academic_id", referencedColumnName = "academic_id")
    private AcademicUnit academicUnit;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    private Semester semester;

    @OneToMany(mappedBy = "studentRegistration")
    private Set<StudentCourse> studentCourses = new HashSet<>();

    public StudentRegistration() {
    }

    public StudentRegistration(UUID registrationId, String registrationCode, Date registrationDate, AcademicUnit academicUnit, Student student, Semester semester) {
        this.registrationId = registrationId;
        this.registrationCode = registrationCode;
        this.registrationDate = registrationDate;
        this.academicUnit = academicUnit;
        this.student = student;
        this.semester = semester;
    }

    public UUID getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(UUID registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    // Add helper methods to manage student courses if necessary
}