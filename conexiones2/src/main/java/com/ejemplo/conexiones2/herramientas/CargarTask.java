package com.ejemplo.conexiones2.herramientas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ejemplo.conexiones2.Empleado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;


public class CargarTask extends Task<ObservableList<Empleado>>{
	String URL = "jdbc:mysql://192.168.1.222/empresax",
	USUARIO = "rusok", PASSWORD = "123456";
	@Override
	protected ObservableList<Empleado> call() throws Exception {
		ObservableList<Empleado> emp = FXCollections.observableArrayList();
		
		updateProgress(0,100);
		Thread.sleep(1000);
		updateProgress(20,100);
		Thread.sleep(1000);
		updateProgress(40,100);
		Thread.sleep(1000);
		updateProgress(60,100);
		Thread.sleep(1000);
		updateProgress(80,100);
		Thread.sleep(1000);
		updateProgress(100,100);
		
		//conectarnos a la base de datos
		try(Connection con = DriverManager.
				getConnection(URL, USUARIO, PASSWORD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM empleado");
			) {
			double actual = 0;
			while(rs.next()) {
				emp.add(new Empleado(rs.getString("id"),
						rs.getString("nombre"),
						rs.getString("apellido")));
				//updateProgress(actual,100);
				//actual+=25;
				
				/********************
				 *  Maneras de establecer la conexión
				 *********************
				//Paso 1: Agregar el driver adecuado 
				//Paso 2: Conectarnos a la base de datos
				DriverManager.getConnection("url");
				DriverManager.getConnection("url", "usuario","password");
				
				//Paso 3:Crear el Statement
				Statement st2 = con.createStatement();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM empleado");
				CallableStatement cst = con.prepareCall("SELECT * FROM empleado");
				
				//Paso 4: Ejecución de consultas
				////Con Statement
				st2.execute("SELECT * FROM empleado"); // Cualquier query SQL
				st2.executeUpdate("INSERT INTO empleado...");// consultas SQL INSERT, UPDATE y DELETE
				st2.executeQuery("SELECT * FROM empleado");
				////Con PreparedStatement
				pst.execute();//sin retorno
				pst.executeUpdate();
				pst.executeQuery();
				////Con CallableStatement
				//Podemos ejecutar llamadas a funciones y procedimientos.
				cst.execute("getestudintes()");//Está por verse
				
				//Pso 5: El manejo de los resultados
				ResultSet rs2 = pst.executeQuery();//SELECT * FROM empleado WHERE ci = 123456
				// -> |
				//    |  pepe | peralta | 123456 |
				rs2.next();
				//    |
				// -> |  pepe | peralta | 123456 |
				String nombre = rs2.getString(1);
				int ci = rs2.getInt("ci");
				
				*/
			}
		}catch(Exception e) {
			System.out.println("Ocurrio un erro al cargar la DDBB " + e.getMessage());
		}
		
		
		try{
			Connection con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
			PreparedStatement pst = con.prepareStatement("INSERT INTO empleado VALUES (?,?,?)");
			pst.setString(1, "2022-02-15-19-22");
			pst.setString(2, "Sofia");
			pst.setString(3, "Lopez");
			int ii = pst.executeUpdate();
			con.close();
			pst.close();
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
		return emp;
	}

}
