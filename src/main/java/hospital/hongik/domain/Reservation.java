package hospital.hongik.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private Long pay;

    public Reservation(Long pay,LocalDateTime time) {
        this.pay = pay;
        this.time = time;
        this.status = ReservationStatus.READY;
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
