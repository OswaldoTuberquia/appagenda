package co.edu.umb.academia.webservice.service;

import co.edu.umb.academia.webservice.entity.Agenda;
import co.edu.umb.academia.webservice.repo.AgendaJpaRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author otuberquia
 */
@Service
public class AgendaServiceImpl implements AgendaService{
    
    @Autowired
    private AgendaJpaRepository repo;

    @Transactional
    @Override
    public void agregarAgenda(Agenda agenda) {
        repo.saveAndFlush(agenda);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Agenda> listarAgendas() {
        return repo.findAll();
    }
    
}
