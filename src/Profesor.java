import java.util.Random;

public class Profesor implements Ausentable{
	//Atributos
	
	private String nombre;
	private int edad;		
	Sexo sexo;
	private Materia enseña;
	private boolean daClase;
	public static int nextId = 1;
	
	//Constructor
	/**
	 * Se utiliza un unico constructor sin parametros donde se asignan valores validos 
	 * para cada campo ya que no es necesario crear instancias personalizadas para cumplir el objetivo del ejercicio.
	 */
	public Profesor() {
		setNombre();
		setEdad();
		setSexo();
		setEnseña();
		setDaClase();
	}
	
	//Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		this.nombre = "Profesor "+nextId;
		incId();
	}
	
	public void incId() {
		nextId++;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad() {
		this.edad = generarEdadProfesor();
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo() {
		this.sexo = randomSex();
	}
	
	public Materia getEnseña() {
		return enseña;
	}

	public void setEnseña() {
		this.enseña = randomMateria();
	}
	
	//setter sobrecargado para poder asignar la materia deseada
	public void setEnseña(Materia mat) {
		this.enseña = mat;
	}

	public boolean isDaClase() {
		return daClase;
	}

	public void setDaClase() {
		this.daClase = estaAusente();
	}
	
	//Metodos de la clase
	
	// Retorna una edad aleatoria entre 25 y 65
	public int generarEdadProfesor() {
		Random rnd = new Random();
		return 25 + rnd.nextInt(40);
	}
	
	// Retorna una de las 3 asignaturas que imparte el profesor de forma aleatoria
	public Materia randomMateria() {
		if (Math.random() < 0.5) return Materia.FILOSOFIA;
		else if (Math.random() < 0.5) return Materia.FISICA;
		else return Materia.MATES;
	}
	
	// Retorna un valor aleatorio para sexo
	public Sexo randomSex() {
		if (Math.random() < 0.5) return Sexo.HOMBRE;
		return Sexo.MUJER;
	}
	
	// Devuelve true si el profesor se ausenta (prob. 20%)
	@Override
	public boolean estaAusente() {
		Random rnd = new Random();
		if (rnd.nextFloat() > 0.8) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", enseña=" + enseña + ", daClase="
				+ daClase;
	}	
	
	
}
