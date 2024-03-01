package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    private String name;

    private Long age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany
    private List<Treat> treats = new ArrayList<>();
}
