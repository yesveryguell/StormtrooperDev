package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jornada;
    private String descripcion;
    private boolean estado;

    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL)
    private List<TurnoCuadrilla> turnoCuadrillas = new ArrayList<>();

    public Turno(Long id) {
        super();
        this.id = id;
    }

    public Turno(Long id, String jornada, String descripcion, boolean estado) {
        this.id = id;
        this.jornada = jornada;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Turno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
