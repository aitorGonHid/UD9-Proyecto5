import java.util.Random;

public class Estudiante implements Ausentable {
	//Atributos
	
	private String nombre;
	private int edad;
	private Sexo sexo;
	private double nota;
	private boolean haceNovillos;
	public static int nextId = 1;
	
	//Constructor
	/**
	 * Se utiliza un unico constructor sin parametros donde se asignan valores validos 
	 * para cada campo ya que no es necesario crear instancias personalizadas para cumplir el objetivo del ejercicio.
	 */
	public Estudiante() {
		setNombre();
		setEdad();
		setSexo();
		setNota();
		setHaceNovillos();
	}
	//Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		this.nombre = "Alumno "+nextId;
		incId();
	}
	
	public void incId() {
		nextId++;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad() {
		this.edad = generarEdadEstudiante();
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo() {
		this.sexo = randomSex();
	}

	public double getNota() {
		return nota;
	}

	public void setNota() {
		this.nota = generarNota();
	}

	public boolean ishaceNovillos() {
		return haceNovillos;
	}
	
	public void setHaceNovillos() {
		this.haceNovillos = estaAusente();
	}
	
	//Metodos de la clase
	
	// Retorna una edad aleatoria entre 17 y 25
	public int generarEdadEstudiante() {
		Random rnd = new Random();
		return 17 + rnd.nextInt(9);
	}
	
	// Retorna una nota entera entre 0 y 10
	public int generarNota() {
		Random rnd = new Random();
		return rnd.nextInt(11);
	}
	
	// Retorna un valor aleatorio para sexo
	public Sexo randomSex() {
		if (Math.random() < 0.5) return Sexo.HOMBRE;
		return Sexo.MUJER;
	}
	
	// Devuelve true/false con una probabilida del 50%
	@Override
	public boolean estaAusente() {
		Random rnd = new Random();
		if (rnd.nextFloat() > 0.5) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", nota=" + nota
				+ ", haceNovillos=" + haceNovillos + "]";
	}
}
