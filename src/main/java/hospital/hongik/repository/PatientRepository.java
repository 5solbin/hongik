package hospital.hongik.repository;

import hospital.hongik.domain.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Patient patient) {
        em.persist(patient);
    }

    public Patient findOne(Long id) {
        return em.find(Patient.class, id);
    }

    public List<Patient> findALl() {
        return em.createQuery("select p from Patient P", Patient.class)
                .getResultList();
    }

    public List<Patient> findByName(String name) {
        return em.createQuery("select p from Patient p where p.name = :name", Patient.class)
                .setParameter("name", name)
                .getResultList();
    }

}
