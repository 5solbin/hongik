package hospital.hongik.repository;

import hospital.hongik.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public void save(Reservation reservation) {
        if (reservation.getId() == null){
            em.persist(reservation);
        }
        // 주문의 상태를 바꾸기 위한 메서드
        else{
            em.merge(reservation);
        }
    }

    public Reservation findOne(Long id) {
        return em.find(Reservation.class, id);
    }

//    public List<Reservation> findAll(ReservationSearch reservationSearch) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
//        Root<Reservation> r = cq.from(Reservation.class);
//        Root<PatientReservation> pr = cq.from(PatientReservation.class);
//        Join<Reservation, PatientReservation> rp = r.join("patientReservation", JoinType.INNER);
//        Join<PatientReservation, Patient> p = pr.join("patient", JoinType.INNER);
//
//        List<Predicate> criteria = new ArrayList<>();
//
////        예약 상태 검색
//        if (reservationSearch.getReservationStatus() != null) {
//            Predicate status = cb.equal(r.get("status"), reservationSearch.getReservationStatus());
//            criteria.add(status);
//        }
//
////        환자 이름 검색
//        if(StringUtils.hasText(reservationSearch.getPatientName())) {
//            Predicate patientName = cb.like(p.<String>get("name"), "%" + reservationSearch.getPatientName() + "%");
//            criteria.add(patientName);
//        }
//
//
//        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
//        TypedQuery<Reservation> query = em.createQuery(cq).setMaxResults(1000);
//
//        return query.getResultList();
//    }

    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();
    }
}
