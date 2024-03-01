package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.domain.Patient;
import hospital.hongik.domain.Treat;
import hospital.hongik.repository.DoctorRepository;
import hospital.hongik.repository.PatientRepository;
import hospital.hongik.repository.TreatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TreatService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final TreatRepository treatRepository;


    /**
     * 진료
     **/
    public Long order(Long patientId, Long doctorId) {

        //엔티티 조회
        Patient patient = patientRepository.findOne(patientId);
        Doctor doctor = doctorRepository.findOne(doctorId);

        //진료 생성
        Treat treat = Treat.createTreat(patient, doctor);

        //저장
        treatRepository.save(treat);
        return treat.getId();
    }
}
