package hospital.hongik.service;

import hospital.hongik.domain.Patient;
import hospital.hongik.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    //회원 가입
    public Long join(Patient patient) {

        validateDuplicatePatient(patient); //중복 회원 검증
        patientRepository.save(patient);
        return patient.getId();
    }

    //중복 회원 검증
    private void validateDuplicatePatient(Patient patient)
    {

        List<Patient> findPatient = patientRepository.findByName(patient.getName());
        if (!findPatient.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
    
}
