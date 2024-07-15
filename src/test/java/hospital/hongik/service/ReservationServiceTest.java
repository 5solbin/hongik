package hospital.hongik.service;

import hospital.hongik.domain.Reservation;
import hospital.hongik.domain.ReservationStatus;
import hospital.hongik.repository.ReservationRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ReservationServiceTest {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationService reservationService;
    @Autowired
    EntityManager em;

//    @Test
//    public void 예약취소() throws Exception{
//        //given
//        Reservation reservation = new Reservation(10000L, LocalDateTime.now());
//        reservationRepository.save(reservation);
//
//        //when
//        reservationService.cancelReservation(reservation.getId());
//
//        //then
//        Assertions.assertEquals(reservation.getStatus() , ReservationStatus.CANCEL);
//    }

}