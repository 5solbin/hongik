package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<PatientReservation> patientReservations = new ArrayList<>();

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<DoctorReservation> doctorReservations = new ArrayList<>();



    private Long pay;

    public Reservation() {
    }

    public Reservation(Long pay,LocalDateTime time, Doctor doctor ,Patient patient) {
        DoctorReservation doctorReservation = new DoctorReservation(doctor);
        PatientReservation patientReservation = new PatientReservation(patient);
        this.addDoctorReservation(doctorReservation);
        this.addPatientReservation(patientReservation);
        this.pay = pay;
        this.time = time;
        this.status = ReservationStatus.READY;
    }

    public void addDoctorReservation(DoctorReservation doctorReservation) {
        doctorReservations.add(doctorReservation);
        doctorReservation.setReservation(this);
    }

    public void addPatientReservation(PatientReservation patientReservation) {
        patientReservations.add(patientReservation);
        patientReservation.setReservation(this);
    }

    //==비즈니스 로직==//
    public void cancel(){
        // 예약 취소 로직
        if (this.status == ReservationStatus.DONE) {
            throw new IllegalStateException("이미 끝난 예약은 취소할 수 없습니다.");
        }
        if (this.status == ReservationStatus.CANCEL) {
            throw new IllegalStateException("이미 취소된 예약입니다.");
        }

        this.status = ReservationStatus.CANCEL;
    }
}
