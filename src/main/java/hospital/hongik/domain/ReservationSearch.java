package hospital.hongik.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservationSearch {

    private String patientName;
    private ReservationStatus reservationStatus;

}
