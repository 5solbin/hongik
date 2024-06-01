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

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    //환자 조회
    public List<Patient> findPatients() {
        return patientRepository.findAll();
    }
}
