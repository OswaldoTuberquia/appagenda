package co.edu.umb.academia.webservice.repo;

import co.edu.umb.academia.webservice.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author otuberquia
 */
@Repository
public interface AgendaJpaRepository extends JpaRepository<Agenda,Integer> {
    
}
