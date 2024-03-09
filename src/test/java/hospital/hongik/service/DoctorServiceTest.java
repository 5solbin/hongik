package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    @Test
    public void 회원가입() throws Exception {

        //given
        Doctor doctor = new Doctor();
        doctor.setName("오솔빈");

        //when
        Long saveId = doctorService.join(doctor);

        //then
        Assertions.assertEquals(doctor, doctorRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예제() throws Exception {
        //given
        Doctor doctor1 = new Doctor();
        doctor1.setName("오솔빈");

        Doctor doctor2 = new Doctor();
        doctor2.setName("오솔빈");

        //when
        doctorService.join(doctor1);


        //then
        assertThrows(IllegalStateException.class, () -> doctorService.join(doctor2));

    }

}