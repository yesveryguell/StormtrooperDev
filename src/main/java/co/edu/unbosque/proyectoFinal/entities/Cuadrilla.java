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

    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    //    @ManyToOne()
//    @JoinColumn(name = "id_turno")
//    private Turno turno;

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

    public Cuadrilla(Long id, EmpresaProveedora empresaProveedora, Usuario usuario, List<TurnoCuadrilla> turnoCuadrillas, List<OrdenTrabajo> ordenTrabajos, Long id_turno, boolean estado) {
        this.id = id;
        this.empresaProveedora = empresaProveedora;
        this.usuario = usuario;
        this.turnoCuadrillas = turnoCuadrillas;
        this.ordenTrabajos = ordenTrabajos;
        this.id_turno = id_turno;
        this.estado = estado;
    }

    public Cuadrilla(Long id, EmpresaProveedora empresaProveedora, Usuario usuario, Long id_turno, boolean estado) {
        this.id = id;
        this.empresaProveedora = empresaProveedora;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<TurnoCuadrilla> getTurnoCuadrillas() {
        return turnoCuadrillas;
    }

    public void setTurnoCuadrillas(List<TurnoCuadrilla> turnoCuadrillas) {
        this.turnoCuadrillas = turnoCuadrillas;
    }

    public List<OrdenTrabajo> getOrdenTrabajos() {
        return ordenTrabajos;
    }

    public void setOrdenTrabajos(List<OrdenTrabajo> ordenTrabajos) {
        this.ordenTrabajos = ordenTrabajos;
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
