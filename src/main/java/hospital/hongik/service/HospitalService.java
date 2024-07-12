package hospital.hongik.service;

import hospital.hongik.domain.Hospital;
import hospital.hongik.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Transactional
    public void join(Hospital hospital) {
        hospitalRepository.save(hospital);
    }
    public List<Hospital> findHospitals() {
        return hospitalRepository.findAll();
    }

}
