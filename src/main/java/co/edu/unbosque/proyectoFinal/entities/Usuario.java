package co.edu.unbosque.proyectoFinal.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne()
    @JoinColumn(name = "id_cuadrilla")
    private Cuadrilla cuadrilla;

    private String nombre;
    private String correo;
    private String contrasena;
    private String telefono;
    private String direccion;
    private boolean estado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Auditoria> auditorias = new ArrayList<>();



    public Usuario(Long id) {
        super();
        this.id = id;
    }

    public Usuario(Long id, Rol rol, Cuadrilla cuadrilla, String nombre, String correo, String contrasena, String telefono, String direccion, boolean estado) {
        this.id = id;
        this.rol = rol;
        this.cuadrilla = cuadrilla;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
