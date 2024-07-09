package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue
    @Column(name = "doctor_id")
    private Long id;

    private String name;

    private Integer career;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
//    private Department department;

    private String department;

    private String hospital;

    public Doctor() {
    }

    public Doctor(String name, Integer career, String department, String hospital) {
        this.name = name;
        this.career = career;
        this.department = department;
        this.hospital = hospital;
    }
}
