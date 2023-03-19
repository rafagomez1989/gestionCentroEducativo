package gestionCentroEducativo.com.rgc.centroEducativo.model;

public class ValoracionMateria {
	private int id;
	private float valoracion;
	private Materia materia;
	private Estudiante estudiante;
	private Profesor profesor;
	
	
	/**
	 * 
	 */
	public ValoracionMateria() {
		super();
	}


	/**
	 * @param id
	 * @param valoracion
	 * @param materia
	 * @param estudiante
	 * @param profesor
	 */
	public ValoracionMateria(int id, float valoracion) {
		super();
		this.id = id;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	/**
	 * 
	 */
	@Override
	public String toString() {
		return ""+valoracion;
	}
}
