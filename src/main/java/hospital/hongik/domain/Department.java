package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
    //hospital과 일대일 연관관계를 가지고 있는데, 주인을 department 쪽에 두었다.
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
