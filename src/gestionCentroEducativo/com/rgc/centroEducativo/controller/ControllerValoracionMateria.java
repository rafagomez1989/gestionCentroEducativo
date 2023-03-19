package gestionCentroEducativo.com.rgc.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestionCentroEducativo.com.rgc.centroEducativo.model.Estudiante;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Materia;
import gestionCentroEducativo.com.rgc.centroEducativo.model.Profesor;
import gestionCentroEducativo.com.rgc.centroEducativo.model.ValoracionMateria;

public class ControllerValoracionMateria {
	
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		ValoracionMateria vm = null;

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				vm = new ValoracionMateria(rs.getInt("id"),rs.getFloat("valoracion"));
				vm.setId(rs.getInt(1));
				vm.setProfesor(introducirIdProfesor(rs.getInt("idProfesor")));
				vm.setEstudiante(introducirIdEstudiante(rs.getInt("idEstudiante")));
				vm.setMateria(introducirIdMateria(rs.getInt("idMateria")));
				

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vm;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static List<ValoracionMateria> findAll() {
		List<ValoracionMateria> vmaterias = new ArrayList<ValoracionMateria>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from valoracionmateria");
			
			while (rs.next()) {
				ValoracionMateria vm = new ValoracionMateria(rs.getInt("id"),rs.getFloat("valoracion"));
				vm.setId(rs.getInt(1));
				vm.setProfesor(introducirIdProfesor(rs.getInt("idProfesor")));
				vm.setEstudiante(introducirIdEstudiante(rs.getInt("idEstudiante")));
				vm.setMateria(introducirIdMateria(rs.getInt("idMateria")));
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return vmaterias;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ValoracionMateria findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id limit 1");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id < " + actualId + " order by id desc limit 1");
	}
	
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (ValoracionMateria vm) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update valoracionmateria set nombre = ?, idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion where id = ?");
		
			ps.setInt(1, vm.getProfesor().getId());
			ps.setInt(2, vm.getEstudiante().getId());
			ps.setInt(3, vm.getMateria().getId());
			ps.setFloat(4, vm.getValoracion());
			ps.setInt(5, vm.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar (ValoracionMateria vm) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into valoracionmateria (idProfesor, idEstudiante, idMateria, valoracion) "
					+ " values (?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setInt(2, vm.getProfesor().getId());
			ps.setInt(3, vm.getEstudiante().getId());
			ps.setInt(4, vm.getMateria().getId());
			ps.setFloat(5, vm.getValoracion());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int eliminar (int id) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from valoracionmateria where id = ?");
		
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param num
	 * @return
	 */
	private static Profesor introducirIdProfesor(int num) {
		Profesor p = new Profesor();
		p.setId(num);
		return p;
	}
	
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	private static Estudiante introducirIdEstudiante(int num) {
		Estudiante e = new Estudiante();
		e.setId(num);
		return e;
	}
	
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	private static Materia introducirIdMateria(int num) {
		Materia m = new Materia();
		m.setId(num);
		return m;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from valoracionmateria");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
