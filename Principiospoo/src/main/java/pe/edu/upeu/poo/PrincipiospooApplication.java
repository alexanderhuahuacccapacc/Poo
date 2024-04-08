package pe.edu.upeu.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.upeu.poo.cobjeto.Persona;

@SpringBootApplication
public class PrincipiospooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrincipiospooApplication.class, args);
                System.out.println("HOLa MUNDO");
                Persona objp=new Persona();
                objp.setNombre("AlexA");
                objp.setEdad(25);
                System.out.println("Nombre: "+objp.getNombre());
                System.out.println("Edad: "+objp.getEdad());
	}

}
