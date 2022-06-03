package co.edu.unbosque.proyectoFinal.entities;
import javax.persistence.*;


@Entity
@Table(name = "operadores")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  int id_cuadrilla;
    private  int id_turno;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private boolean estado ;

    public Operador() {
    }

    public Operador(Long id, int id_cuadrilla, int id_turno, String nombre, String apellido, String cedula, String telefono, boolean estado) {
        this.id = id;
        this.id_cuadrilla = id_cuadrilla;
        this.id_turno = id_turno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_cuadrilla() {
        return id_cuadrilla;
    }

    public void setId_cuadrilla(int id_cuadrilla) {
        this.id_cuadrilla = id_cuadrilla;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
