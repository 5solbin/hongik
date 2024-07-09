package hospital.hongik.controller;

import hospital.hongik.domain.Gender;
import hospital.hongik.domain.Patient;
import hospital.hongik.service.PatientService;
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
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients/new")
    public String createForm(Model model) {
        model.addAttribute("patientForm", new PatientForm());
        return "patients/createPatientForm";
    }

    @PostMapping("/patients/new")
//    파라미터 에 대해서 좀더 알아야 겠다.
    public String create(@Valid PatientForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "patients/createPatientForm";
        }

        Patient patient = new Patient();
        patient.setName(form.getName());
        patient.setAge(form.getAge());
        patient.setGender(form.getGender());

        patientService.join(patient);

        return "redirect:/";
    }

    @GetMapping(value = "/patients")
    public String list(Model model) {
        List<Patient> patients = patientService.findPatients();
        model.addAttribute("patients", patients);
        return "patients/patientList";
    }

    // 테스트용 데이터
    @PostConstruct
    public void init() {
        patientService.join(new Patient("오솔빈", 23, Gender.남));
        patientService.join(new Patient("이은총", 23, Gender.여));
    }
}
