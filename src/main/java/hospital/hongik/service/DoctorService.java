package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional
    public void join(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findDoctors() {
        return doctorRepository.findAll();
    }
}
