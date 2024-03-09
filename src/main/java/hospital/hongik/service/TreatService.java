package hospital.hongik.service;

import hospital.hongik.domain.Doctor;
import hospital.hongik.domain.Patient;
import hospital.hongik.domain.Treat;
import hospital.hongik.domain.TreatStatus;
import hospital.hongik.repository.DoctorRepository;
import hospital.hongik.repository.PatientRepository;
import hospital.hongik.repository.TreatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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
    public Long order(Patient patient, Doctor doctor, Treat treat) {

        //진료 생성
        treat.setDoctor(doctor);
        treat.setPatient(patient);
        treat.setTreatStatus(TreatStatus.YET);
        treat.setDate(LocalDate.now().plusDays(5));
//        validDuplicateTreat(treat);
        //저장
        treatRepository.save(treat);
        return treat.getId();
    }

//    private void validDuplicateTreat(Treat treat) {
//
//        List<Treat> findTreat = treatRepository.findByDate(treat.getDate());
//        if (!findTreat.isEmpty()) {
//            throw new IllegalStateException("해당 날짜에 이미 예약이 있습니다.");
//        }
//    }

    public void Done(Treat treat) {

    }
}
