package hospital.hongik.repository;

import hospital.hongik.domain.Hospital;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HospitalRepository {

    private final EntityManager em;

    public void save(Hospital hospital) {
        em.persist(hospital);
    }

    public Hospital findOne(Long id) {
        return em.find(Hospital.class,id);
    }

    public List<Hospital> findAll() {
        return em.createQuery("select h from Hospital h",Hospital.class)
                .getResultList();
    }

    //createQuery는 무조건 리스트로 반환해야되나? 파라미터 바인딩에 대해서
    public Hospital findByName(String name) {
        return em.createQuery("select h from Hospital h where h.name = :name", Hospital.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
