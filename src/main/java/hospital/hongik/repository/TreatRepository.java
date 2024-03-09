package hospital.hongik.repository;

import hospital.hongik.domain.Treat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

//    public List<Treat> findByDate(LocalDate date) {
//        return em.createQuery("select t from Treat t where t.date = date", Treat.class)
//                .getResultList();
//    }
}
