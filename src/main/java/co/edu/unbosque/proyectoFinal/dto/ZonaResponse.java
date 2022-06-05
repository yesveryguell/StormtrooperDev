package co.edu.unbosque.proyectoFinal.dto;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ZonaResponse {

    private Long id;
    private Ciudad ciudad;
    private int vertice1;
    private int vertice2;
    private int vertice3;
    private int vertice4;
    private boolean estado;

    public ZonaResponse() {
    }

    public ZonaResponse(Long id, Ciudad ciudad, int vertice1, int vertice2, int vertice3, int vertice4, boolean estado) {
        this.id = id;
        this.ciudad = ciudad;
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        this.vertice4 = vertice4;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
