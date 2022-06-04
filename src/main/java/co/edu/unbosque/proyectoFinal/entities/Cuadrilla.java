package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cuadrilla {

    @Id
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private EmpresaProveedora empresaProveedora;
    private Long id_turno;
    private boolean estado;

    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL)
    private List<Operador> operadores = new ArrayList<>();

    @OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL)
    private List<OrdenTrabajo> ordenTrabajos = new ArrayList<>();

    public Cuadrilla() {
    }

    public Cuadrilla(Long id, Long id_turno, boolean estado) {
        this.id = id;
        this.id_turno = id_turno;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
