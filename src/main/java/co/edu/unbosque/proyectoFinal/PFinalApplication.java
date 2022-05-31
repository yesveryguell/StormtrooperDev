package co.edu.unbosque.proyectoFinal;

import co.edu.unbosque.proyectoFinal.entities.Operador;
import co.edu.unbosque.proyectoFinal.repository.OperadorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PFinalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PFinalApplication.class, args);
		OperadorRepository repository = context.getBean(OperadorRepository.class);

		//crear operador
		Operador operador1 = new Operador(null, 1, 1, "juan", "perez", "1007635379", "8631514", "A");
		Operador operador2 = new Operador(null, 1, 2, "juan", "perez", "1007635379", "8631514", "B");

		//almacenar operador
		repository.save(operador1);
		repository.save(operador2);
		//recuperar operador
		System.out.println(repository.findAll().size());
		//borrar operador

	}
}
