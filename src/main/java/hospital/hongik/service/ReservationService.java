package hospital.hongik.service;

import hospital.hongik.domain.*;
import hospital.hongik.repository.DoctorRepository;
import hospital.hongik.repository.PatientRepository;
import hospital.hongik.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public void reservation (Long patientId, Long doctorId, Long pay, LocalDateTime time) {
        Doctor doctor = doctorRepository.findOne(doctorId);
        Patient patient = patientRepository.findOne(patientId);

        Reservation reservation = new Reservation(pay,time,doctor,patient);
        reservationRepository.save(reservation);
    }

    public List<Reservation> findReservations(){
        return reservationRepository.findAll();
    }

    @Transactional
    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findOne(id);
        reservation.cancel();
    }
}
