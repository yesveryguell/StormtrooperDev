package co.edu.unbosque.proyectoFinal;

import co.edu.unbosque.proyectoFinal.entities.Operador;
import co.edu.unbosque.proyectoFinal.entities.Usuario;
import co.edu.unbosque.proyectoFinal.repository.OperadorRepository;
import co.edu.unbosque.proyectoFinal.repository.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PFinalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PFinalApplication.class, args);
		OperadorRepository repository = context.getBean(OperadorRepository.class);
		UsuarioRepository usuarioRepository = context.getBean(UsuarioRepository.class);

		//crear operador
		Operador operador1 = new Operador(null, 1, 1, "juan", "perez", "1007635379", "8631514", true);
		Operador operador2 = new Operador(null, 1, 2, "juan", "perez", "1007635379", "8631514", false );
		Usuario usuario1 = new Usuario(null, 2,"sergio","sda@gmail.com","123456","8631514", "calle 19",true);
		Usuario usuario2 = new Usuario(null, 1,"pedro","PJK@gmail.com","654321","86315154", "calle 120",true);
		System.out.println(usuario1);
		//almacenar operador
		repository.save(operador1);
		repository.save(operador2);
		usuarioRepository.save(usuario1);
		usuarioRepository.save(usuario2);
		//recuperar operador
		System.out.println(repository.findAll().size());
		//borrar operador

	}
}
