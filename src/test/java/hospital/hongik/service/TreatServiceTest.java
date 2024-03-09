package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.domain.Patient;
import hospital.hongik.domain.Treat;
import hospital.hongik.repository.TreatRepository;
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
class TreatServiceTest {
    @Autowired
    TreatRepository treatRepository;
    @Autowired
    TreatService treatService;

    @Test
    public void 진료_생성() throws Exception{
        //given
        Treat treat = new Treat();
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        //when
        Long saveId = treatService.order(patient, doctor , treat);

        //then
        Assertions.assertEquals(treat, treatRepository.findOne(saveId));
    }
}