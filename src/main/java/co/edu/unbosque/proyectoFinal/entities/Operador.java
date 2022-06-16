package co.edu.unbosque.proyectoFinal.entities;

import javax.persistence.*;


@Entity
@Table(name = "operadores")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuadrilla")
    private Cuadrilla cuadrilla;
    private String nombre;
    private String apellido;
    private String cedula;
    private boolean estado;

    public Operador(Long id) {
        super();
        this.id = id;

    }

    public Operador(Long id, Cuadrilla cuadrilla, String nombre, String apellido, String cedula, boolean estado) {
        this.id = id;
        this.cuadrilla = cuadrilla;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.estado = estado;
    }

    public Operador() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
