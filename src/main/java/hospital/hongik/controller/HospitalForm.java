package hospital.hongik.controller;

import hospital.hongik.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HospitalForm {

    private String name;
    private String city;
    private String street;
    private String zipcode;
    private String dep;

}
