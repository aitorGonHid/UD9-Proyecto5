import java.util.Random;

public class Proyecto5App {

	public static void main(String[] args) {

		//Crea una nueva aula y se muestra por pantalla
		Aula aula404 = new Aula(404, 2, Materia.MATES);
		System.out.println(aula404.toString()+"\n");
		
		//Se le asigna un profesor (este tiene datos aleatorios) y se muestra el profesor asignado
		aula404.setProfe(new Profesor());
		//aula404.getProfe().setEnseña(Materia.MATES); // <-- Quitar comentario para satisfacer la condicion de asignatura que se imparte e imparte el profesor
		System.out.println("Profesor asignado: " + aula404.getProfe().toString()+"\n");
		
		//Se le asigna los alumnos a la clase
		aula404.llenarAula();
		System.out.println("Se han asignado " + aula404.getAforo() + " alumnos.\n");
		
		//Se comprueba si se puede dar clase
		//Si es posible se muestran las notas de los alumnos aprobados (aunque hayan hecho novillos ese dia)
		if (aula404.hayClase()) {
			System.out.println("Hoy se han repartido las notas finales !! \n");
			aula404.showAlumnosAprobados();
			aula404.showAlumnasAprobadas();
		} else {
			System.out.println("Hoy no ha sido posible dar clase !!");
		}
	}
}
