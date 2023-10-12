package co.edu.umb.academia.webservice.api;

import co.edu.umb.academia.webservice.entity.Agenda;
import co.edu.umb.academia.webservice.entity.ResponseApi;
import co.edu.umb.academia.webservice.service.AgendaService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author otuberquia
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Slf4j
public class AgendaController {

    @Autowired
    private AgendaService service;

    @PostMapping({"/agregaragenda"})
    public ResponseEntity<ResponseApi> apiAgregarAgenda(
            @RequestParam(value = "pFecha", required = false) String pFecha,
            @RequestParam(value = "pAsunto", required = false) String pAsunto,
                @RequestParam(value = "pActividad", required = false) String pActividad
    ) {
        ResponseApi apiMsg = new ResponseApi();
        try {
            service.agregarAgenda(new Agenda(0, pFecha, pAsunto, pActividad));
            apiMsg.setMessage( "Registro procesado correctamente!");
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            apiMsg.setMessage(errors.toString());
            return new ResponseEntity(apiMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(apiMsg, HttpStatus.OK);
    }

    @GetMapping({"/agendas"})
    public List<Agenda> apiListarAgenda() {
        try {
            return service.listarAgendas();
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
        }
        return null;
    }
}
