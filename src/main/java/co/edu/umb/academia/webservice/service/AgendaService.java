package co.edu.umb.academia.webservice.service;

import co.edu.umb.academia.webservice.entity.Agenda;
import java.util.List;

/**
 *
 * @author otuberquia
 */
public interface AgendaService {

    public void agregarAgenda(Agenda agenda);

    public List<Agenda> listarAgendas();
}
