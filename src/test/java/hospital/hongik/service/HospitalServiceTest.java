package hospital.hongik.service;

import hospital.hongik.domain.Address;
import hospital.hongik.domain.Department;
import hospital.hongik.domain.Hospital;
import hospital.hongik.repository.HospitalRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class HospitalServiceTest {
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    EntityManager em;

    @Test
    public void 병원_목록_출력() throws Exception{
        //given
        Address address1 = new Address("서울", "마포구", "홍익");
        Address address2 = new Address("경기", "구리시", "이문안");
        Address address3 = new Address("부산", "해운대구", "해운대");
        Department department1 = new Department("정형외과");
        Department department2 = new Department("안과");
        Department department3 = new Department("성형외과");
        Hospital hospital1 = new Hospital("홍익병원", address1, department1);
        Hospital hospital2 = new Hospital("구리병원", address2, department2);
        Hospital hospital3 = new Hospital("부산병원", address3, department3);

        //when
        hospitalRepository.save(hospital1);
        hospitalRepository.save(hospital2);
        hospitalRepository.save(hospital3);
        List<Hospital> hospitals = hospitalService.findHospitals();

        //then
        Assertions.assertThat(hospitals).isNotNull();
        for (Hospital h : hospitals) {
            System.out.println(h.getName());
        }
    }
}