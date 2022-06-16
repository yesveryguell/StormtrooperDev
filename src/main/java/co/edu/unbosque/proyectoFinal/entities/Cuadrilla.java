package co.edu.unbosque.proyectoFinal.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "cuadrilla")
public class Cuadrilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_empresa")
    private EmpresaProveedora empresaProveedora;

    //    @ManyToOne()
//    @JoinColumn(name = "id_turno")
//    private Turno turno;
    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TurnoCuadrilla> turnoCuadrillas;

    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenTrabajo> ordenTrabajos;

    private Long id_turno;
    private boolean estado;


    public Cuadrilla(Long id) {
        super();
        this.id = id;
    }

    public Cuadrilla(Long id, EmpresaProveedora empresaProveedora, Long id_turno, boolean estado) {
        this.id = id;
        this.empresaProveedora = empresaProveedora;
        this.id_turno = id_turno;
        this.estado = estado;
    }

    public Cuadrilla() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaProveedora getEmpresaProveedora() {
        return empresaProveedora;
    }

    public void setEmpresaProveedora(EmpresaProveedora empresaProveedora) {
        this.empresaProveedora = empresaProveedora;
    }

    public Long getId_turno() {
        return id_turno;
    }

    public void setId_turno(Long id_turno) {
        this.id_turno = id_turno;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
//    public TurnoCuadrilla getTurnoCuadrilla() {
//        return turnoCuadrilla;
//    }
//
//    public void setTurnoCuadrilla(TurnoCuadrilla turnoCuadrilla) {
//        this.turnoCuadrilla = turnoCuadrilla;
//    }

    public Cuadrilla getCuadrilla() {
        Cuadrilla cuadrilla = new Cuadrilla();
        cuadrilla.setId(this.id);
        cuadrilla.setId_turno(this.id_turno);
        cuadrilla.setEstado(this.estado);
        return cuadrilla;
    }
}
