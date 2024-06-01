package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToOne (fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors = new ArrayList<>();

    protected Department() {

    }

    // 이건 굳이?
    public Department(String name) {
        this.name = name;
    }
}
