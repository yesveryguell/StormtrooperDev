package co.edu.unbosque.proyectoFinal.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "ordenTrabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_zona")
    private Zona zona;

    private String nombretrabajo;
    private Calendar fecha_inicio;
    private Calendar fecha_fin;
    private boolean estado;

    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Material> material;


    public OrdenTrabajo(Long id) {
        super();
        this.id = id;

    }

    public OrdenTrabajo(Long id, Zona zona, String nombretrabajo, Calendar fecha_inicio, Calendar fecha_fin, boolean estado) {
        this.id = id;
        this.zona = zona;
        this.nombretrabajo = nombretrabajo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public OrdenTrabajo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getNombretrabajo() {
        return nombretrabajo;
    }

    public void setNombretrabajo(String nombretrabajo) {
        this.nombretrabajo = nombretrabajo;
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
}
