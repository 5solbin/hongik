package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    //회원 가입
    public Long join(Doctor doctor) {

        validateDuplicatePatient(doctor); //중복 회원 검증
        doctorRepository.save(doctor);
        return doctor.getId();
    }

    //중복 회원 검증
    private void validateDuplicatePatient(Doctor doctor)
    {

        List<Doctor> findDoctor = doctorRepository.findByName(doctor.getName());
        if (!findDoctor.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

}
