package co.edu.unbosque.proyectoFinal.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_ordenTrabajo")
    private OrdenTrabajo ordenTrabajo;

    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;
    private boolean estado;

    public Material(Long id) {
        super();
        this.id = id;
    }

    public Material(Long id, OrdenTrabajo ordenTrabajo, String nombre, String descripcion, int cantidad, int precio, boolean estado) {
        this.id = id;
        this.ordenTrabajo = ordenTrabajo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    public Material() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Material getMaterial() {
        Material material = new Material();
        material.setId(id);
        material.setOrdenTrabajo(ordenTrabajo);
        material.setNombre(nombre);
        material.setDescripcion(descripcion);
        material.setCantidad(cantidad);
        material.setPrecio(precio);
        material.setEstado(estado);
        return material;
    }
}
