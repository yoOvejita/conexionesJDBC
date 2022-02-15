package com.ejemplo.conexiones2.herramientas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ejemplo.conexiones2.Empleado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;


public class CargarTask extends Task<ObservableList<Empleado>>{

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
				getConnection("jdbc:mysql://192.168.1.217/empresax", "rusok", "123456");
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
			}
		}catch(Exception e) {
			System.out.println("Ocurrio un erro al cargar la DDBB " + e.getMessage());
		}
		
		
		return emp;
	}

}
