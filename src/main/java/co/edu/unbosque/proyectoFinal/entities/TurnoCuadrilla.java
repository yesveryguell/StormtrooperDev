package co.edu.unbosque.proyectoFinal.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "turnoCuadrilla")
public class TurnoCuadrilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "turnoCuadrilla", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "id_cuadrilla")
//    private List<Cuadrilla> cuadrillas;
    @ManyToOne()
    @JoinColumn(name = "id_cuadrilla")
    private Cuadrilla cuadrilla;

    @ManyToOne()
    @JoinColumn(name = "id_Turno")
    private Turno turno;

    private boolean estado;

    public TurnoCuadrilla(Long id) {
        super();
        this.id = id;
    }

    public TurnoCuadrilla(Long id, Cuadrilla cuadrilla, Turno turno, boolean estado) {
        this.id = id;
        this.cuadrilla = cuadrilla;
        this.turno = turno;
        this.estado = estado;
    }

    public TurnoCuadrilla() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TurnoCuadrilla getTurnoCuadrilla() {
        TurnoCuadrilla turnoCuadrilla = new TurnoCuadrilla();
        turnoCuadrilla.setId(this.id);
        turnoCuadrilla.setCuadrilla(this.cuadrilla);
        turnoCuadrilla.setTurno(this.turno);
        turnoCuadrilla.setEstado(this.estado);
        return turnoCuadrilla;
    }
}
