package hospital.hongik.controller;

import hospital.hongik.domain.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientForm {

    @NotEmpty(message = "이름은 필수 입니다!")
    private String name;

    private Integer age;
    private Gender gender;
}
