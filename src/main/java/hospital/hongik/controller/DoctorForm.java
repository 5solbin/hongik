package hospital.hongik.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DoctorForm {
    @NotEmpty(message = "이름은 필수 사항 입니다")
    private String name;

    private Integer career;
    private String hospital;
    private String department;
}
