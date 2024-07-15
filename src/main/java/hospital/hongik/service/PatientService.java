package hospital.hongik.service;

import hospital.hongik.domain.Patient;
import hospital.hongik.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional //요걸 빼먹어 버리네
    public void join(Patient patient) {
        patientRepository.save(patient);
    }

    //환자 조회
    public List<Patient> findPatients() {
        return patientRepository.findAll();
    }


}
