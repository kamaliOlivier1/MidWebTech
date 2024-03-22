package MODEL;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @Column(name = "semester_id", updatable = false, nullable = false)
    private UUID semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Semester() {
    }

    public Semester(UUID semesterId, String semesterName, LocalDate startingDate, LocalDate endDate) {
      this.semesterId = semesterId;
      this.semesterName = semesterName;
      this.startingDate = startingDate;
      this.endDate = endDate;
    }

    public UUID getSemesterId() {
      return semesterId;
    }

    public void setSemesterId(UUID semesterId) {
      this.semesterId = semesterId;
    }

    public String getSemesterName() {
      return semesterName;
    }

    public void setSemesterName(String semesterName) {
      this.semesterName = semesterName;
    }

    public LocalDate getStartingDate() {
      return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
      this.startingDate = startingDate;
    }

    public LocalDate getEndDate() {
      return endDate;
    }

    public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
    }
    
}