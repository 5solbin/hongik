package hospital.hongik.repository;

import hospital.hongik.domain.Treat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TreatRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Treat treat) {
        em.persist(treat);
    }

    public Treat findOne(Long id) {
        return em.find(Treat.class,id);
    }
}
