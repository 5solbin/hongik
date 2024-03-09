package hospital.hongik.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter @Setter
public class Treat {

    @Id
    @GeneratedValue
    @Column(name = "treat_id")
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private LocalDate date;

    private Long price;

    @Enumerated(EnumType.STRING)
    private TreatStatus treatStatus;

    //얀관관계 메서드
    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.getTreats().add(this);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        doctor.getTreats().add(this);
    }

    //생성 메서드
    public static Treat createTreat(Patient patient, Doctor doctor) {
        Treat treat = new Treat();
        treat.setPatient(patient);
        treat.setDoctor(doctor);
        return treat;
    }
}
