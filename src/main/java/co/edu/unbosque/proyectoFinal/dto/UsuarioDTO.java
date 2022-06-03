package co.edu.unbosque.proyectoFinal.dto;
import co.edu.unbosque.proyectoFinal.entities.Usuario;
import java.util.List;

public class UsuarioDTO {
    private List<Usuario> usuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }


}
