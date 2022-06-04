package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;

@Entity
public class TurnoCuadrilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_Cuadrilla;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Turno")
    private Turno turno;
    private boolean estado;

    public TurnoCuadrilla(){

    }

    public TurnoCuadrilla(Long id, Long id_Cuadrilla, Turno turno, boolean estado) {
        this.id = id;
        this.id_Cuadrilla = id_Cuadrilla;
        this.turno = turno;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_Cuadrilla() {
        return id_Cuadrilla;
    }

    public void setId_Cuadrilla(Long id_Cuadrilla) {
        this.id_Cuadrilla = id_Cuadrilla;
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
}
