package gestionCentroEducativo.com.rgc.centroEducativo.model;

public class Materia {
	private int id;
	private String nombre;
	private String acronimo;
	private Curso Curso;
	
	
	/**
	 * 
	 */
	public Materia() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param acronimo
	 * @param idCurso
	 */
	public Materia(int id, String nombre, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public Curso getCurso() {
		return Curso;
	}
	public void setCurso(Curso curso) {
		this.Curso = curso;
	}


	@Override
	public String toString() {
		return nombre;
	}
}
