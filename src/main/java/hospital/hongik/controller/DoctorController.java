package hospital.hongik.controller;

import hospital.hongik.domain.Doctor;
import hospital.hongik.service.DoctorService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors/new")
    public String createForm(Model model) {
        model.addAttribute("doctorForm", new DoctorForm());
        return "doctors/createDoctorForm";
    }

    @PostMapping("/doctors/new")
    public String create(@Valid DoctorForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "doctors/createDoctorForm";
        }

        Doctor doctor = new Doctor();
        doctor.setName(form.getName());
        doctor.setDepartment(form.getDepartment());
        doctor.setCareer(form.getCareer());
        doctor.setHospital(form.getHospital());

        doctorService.join(doctor);

        return "redirect:/";
    }

    @GetMapping("/doctors")
    public String list(Model model) {

        List<Doctor> doctors = doctorService.findDoctors();
        model.addAttribute("doctors",doctors);
        return "doctors/doctorList";
    }

    //테스트용 데이터
    @PostConstruct
    public void init() {
        doctorService.join(new Doctor("뼈다귀" , 10, "정형외과", "으라차차 정형외과"));
        doctorService.join(new Doctor("목구멍" , 10, "이비인후과", "후욱후욱 이비인후과"));
    }
}
