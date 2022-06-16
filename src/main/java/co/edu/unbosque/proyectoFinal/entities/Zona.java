package co.edu.unbosque.proyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 //   private Long ciuda
    @ManyToOne()
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
   // private Ciudad ciudad;
    private int vertice1;
    private int vertice2;
    private int vertice3;
    private int vertice4;
    private boolean estado;
    @JsonIgnore
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenTrabajo> ordenTrabajo;


    public Zona(Long id){
            super();
            this.id = id;
    }

    public Zona(Long id, Ciudad ciudad, int vertice1, int vertice2, int vertice3, int vertice4, boolean estado) {
        this.id = id;
        this.ciudad = ciudad;
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        this.vertice4 = vertice4;
        this.estado = estado;
    }

    public Zona() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getVertice1() {
        return vertice1;
    }

    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }

    public int getVertice2() {
        return vertice2;
    }

    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    public int getVertice3() {
        return vertice3;
    }

    public void setVertice3(int vertice3) {
        this.vertice3 = vertice3;
    }

    public int getVertice4() {
        return vertice4;
    }

    public void setVertice4(int vertice4) {
        this.vertice4 = vertice4;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Zona getZona() {
        Zona zona = new Zona();
        zona.setId(id);
        zona.setCiudad(ciudad);
        zona.setVertice1(vertice1);
        zona.setVertice2(vertice2);
        zona.setVertice3(vertice3);
        zona.setVertice4(vertice4);
        zona.setEstado(estado);
        return zona;
    }
}
