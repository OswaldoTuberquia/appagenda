package co.edu.umb.academia.webservice.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author otuberquia
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_agenda")
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idagenda;
    private String fecha;
    private String asunto;
    private String actividad;
}
