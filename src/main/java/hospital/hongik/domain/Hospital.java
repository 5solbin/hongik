package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue
    @Column(name = "hospital_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "hospital" , cascade = CascadeType.ALL)
    private Department department;

    public Hospital() {}
    public Hospital(String name, Address address, Department department) {
        this.name = name;
        this.address = address;
        this.department = department;
        department.setHospital(this);
    }
}
