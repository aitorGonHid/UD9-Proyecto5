
public class Aula {
	//Atributos
	
	private int id;
	private int aforo;
	private Materia seImparte;
	private Profesor profe;
	private Estudiante[] alumnos;
	
	//Constructor
	
	public Aula(int id, int aforo, Materia seImparte) {
		this.id = id;
		this.aforo = aforo;
		this.seImparte = seImparte;
		this.profe = profe;
		this.alumnos = new Estudiante[aforo];
	}
	
	//Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public Materia getSeImparte() {
		return seImparte;
	}

	public void setSeImparte(Materia seImparte) {
		this.seImparte = seImparte;
	}

	public Profesor getProfe() {
		return profe;
	}

	public void setProfe(Profesor profe) {
		this.profe = profe;
	}

	public Estudiante[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Estudiante[] alumnos) {
		this.alumnos = alumnos;
	}
	
	// Métodos de la clase
	// LLena el aula de nuevos alumnos
	public void llenarAula() {
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = new Estudiante();
		}
	}
	
	//Valida que el profesor de la asignatura a la que esta destinada el aula y si no se ha ausentado
	public boolean checkProfesor() {
		//Si el profesor no esta presente no es necesario comprobar que asignatura imparte
		if (!(this.getProfe().isDaClase())) return false;
		//Si el profesor esta presente se comprueba que la asignatura que imparte es la adecuada
		boolean mismaAsignatura = (this.getSeImparte() == this.getProfe().getEnseña()) ? true : false;
		return mismaAsignatura;
	}
	
	//Comprueba si hay una asistencia superior al 50% por parte de los alumnos
	public boolean checkAsistencia() {
		int presentes = 0;
		// conteo de los alumnos presentes
		for (Estudiante estudiante : this.getAlumnos()) {
			if (!(estudiante.ishaceNovillos())) presentes++;
		}
		//verificación de asistencia (presentes debe ser mayor que el 50% del aforo)
		if (presentes > this.getAforo()/2) return true;
		return false;
	}
	// Verifica si se puede dar clase usando los métodos checkAsistencia() y checkProfesor()
	public boolean hayClase() {
		if (checkProfesor() && checkAsistencia()) return true;
		return false;
	}
	
	// Muestra los alumnos aprobados por consola
	public void showAlumnosAprobados() {
		System.out.println("Alumnos aprobados: ");
		for (Estudiante est : this.getAlumnos()) {
			if (est.getSexo().name().equals("HOMBRE") && est.getNota() >= 5) {
				System.out.println(est.toString());
			}
		}
		System.out.println();
	}

	// Muestra los alumnos aprobados por consola
	public void showAlumnasAprobadas() {
		System.out.println("Alumnas aprobadas: ");
		for (Estudiante est : this.getAlumnos()) {
			if (est.getSexo().name().equals("MUJER") && est.getNota() >= 5) {
				System.out.println(est.toString());
			}
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "El aula " + id + " donde se imparte " + seImparte + " tiene un aforo de "  + aforo + " alumnos";
	}
}
