package co.edu.unbosque.proyectoFinal.dto;


import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ZonaRequest {
    private Ciudad ciudad;
}
