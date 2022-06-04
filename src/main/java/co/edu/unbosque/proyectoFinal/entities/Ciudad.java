package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean estado;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Zona> zonas = new ArrayList<>();

    public Ciudad(){

    }

    public Ciudad(Long id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
