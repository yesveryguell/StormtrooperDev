package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private Date fecha;
    private String evento;

    public Auditoria(Long id){
        super();
        this.id=id;

    }

    public Auditoria(Long id, Date fecha, String evento) {
        this.id = id;
        this.fecha = fecha;
        this.evento = evento;
    }

    public Auditoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
}

