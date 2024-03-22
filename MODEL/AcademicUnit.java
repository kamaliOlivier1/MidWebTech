package MODEL;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "academic_id", updatable = false, nullable = false)
    private UUID academicId;

    @Column(name = "academic_code")
    private String academicCode;

    @Column(name = "academic_name")
    private String academicName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
   // private AcademicUnitType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parent;

    public AcademicUnit() {
    }}

   