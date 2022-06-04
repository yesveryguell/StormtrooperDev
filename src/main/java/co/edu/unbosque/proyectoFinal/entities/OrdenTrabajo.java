package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuadrilla")
    private Cuadrilla cuadrilla;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona")
    private Zona zona;
    private String nombre_trabajo;
    private Calendar fecha_inicio;
    private Calendar fecha_fin;
    private boolean estado;

    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL)
    private List<Material> materials = new ArrayList<>();

    public OrdenTrabajo(){

    }

    public OrdenTrabajo(Long id, Cuadrilla cuadrilla, Zona zona, String nombre_trabajo, Calendar fecha_inicio, Calendar fecha_fin, boolean estado, List<Material> materials) {
        this.id = id;
        this.cuadrilla = cuadrilla;
        this.zona = zona;
        this.nombre_trabajo = nombre_trabajo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.materials = materials;
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

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getNombre_trabajo() {
        return nombre_trabajo;
    }

    public void setNombre_trabajo(String nombre_trabajo) {
        this.nombre_trabajo = nombre_trabajo;
    }

    public Calendar getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Calendar fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Calendar getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Calendar fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
