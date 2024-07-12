package hospital.hongik.controller;

import hospital.hongik.domain.Address;
import hospital.hongik.domain.Department;
import hospital.hongik.domain.Hospital;
import hospital.hongik.service.HospitalService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/hospitals/new")
    public String createForm(Model model) {
        model.addAttribute("hospitalForm", new HospitalForm());
        return "hospitals/createHospitalForm";
    }

    @PostMapping("/hostpials/new")
    public String create(@Valid HospitalForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "hospitals/createHostpialForm";
        }

        Hospital hospital = new Hospital();
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Department department = new Department(form.getDep());

        hospital.setAddress(address);
        hospital.setName(form.getName());
        hospital.setDepartment(department);


        hospitalService.join(hospital);

        return "redirect:/";
    }

    @GetMapping("/hospitals")
    public String list(Model model) {

        List<Hospital> hospitals = hospitalService.findHospitals();
        model.addAttribute("hospitals", hospitals);
        return "hospitals/hospitalList";

    }

    @PostConstruct
    public void init() {
        Address address1 = new Address("서울", "마포구", "홍익");
        Address address2 = new Address("경기", "구리시", "이문안");
        Address address3 = new Address("부산", "해운대구", "해운대");

        Department department1 = new Department("정형외과");
        Department department2 = new Department("안과");
        Department department3 = new Department("성형외과");

        Hospital hospital1 = new Hospital("홍익병원", address1, department1);
        Hospital hospital2 = new Hospital("구리병원", address2, department2);
        Hospital hospital3 = new Hospital("부산병원", address3, department3);

        hospitalService.join(hospital1);
        hospitalService.join(hospital2);
        hospitalService.join(hospital3);
    }
}
