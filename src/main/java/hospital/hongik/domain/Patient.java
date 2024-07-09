package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Patient {
    //환자 엔티티
    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Patient() {
    }

    public Patient(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
