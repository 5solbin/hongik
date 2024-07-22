package hospital.hongik.controller;

import hospital.hongik.domain.*;
import hospital.hongik.service.DoctorService;
import hospital.hongik.service.PatientService;
import hospital.hongik.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final ReservationService reservationService;

    @GetMapping("/reservation")
    public String createForm(Model model) {

        List<Patient> patients = patientService.findPatients();
        List<Doctor> doctors = doctorService.findDoctors();

        model.addAttribute("patients", patients);
        model.addAttribute("doctors", doctors);

        return "reservations/reservationForm";
    }

    @PostMapping("/reservation")
    public String reservation(@RequestParam("patientId") Long patientId,
                              @RequestParam("doctorId") Long doctorId) {
        Long pay = 10000L; //일단 고정
        LocalDateTime time = LocalDateTime.now().plusDays(14); // 이거도 일단 고정

        reservationService.reservation(patientId, doctorId, pay, time);

        return "redirect:/reservations";
    }

    @GetMapping("/reservations")
    public String reservationList(Model model) {

        List<Reservation> reservations = reservationService.findReservations();
        List<PatientReservation> patientReservations = new ArrayList<>();
        List<DoctorReservation> doctorReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            for (DoctorReservation doctorReservation : reservation.getDoctorReservations()){
                doctorReservations.add(doctorReservation);
            }

            for (PatientReservation patientReservation : reservation.getPatientReservations()){
                patientReservations.add(patientReservation);
            }
        }
        model.addAttribute("reservations", reservations);
        model.addAttribute("patientReservations", patientReservations);
        model.addAttribute("doctorReservations", doctorReservations);

        return "reservations/reservationList";

    }

    @PostMapping("/reservations/{reservationId}/cancel")
    public String cancelReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return "redirect:/reservations";
    }
}
