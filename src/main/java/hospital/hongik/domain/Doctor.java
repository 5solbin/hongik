package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Doctor {

    @Id
    @GeneratedValue
    @Column(name = "doctor_id")
    private Long id;

    private String name;

    private Long career;

    @OneToMany //다수의 정보를 받아야 하므로 리스트 형태로 받자
    private List<Treat> treats = new ArrayList<>();

}
