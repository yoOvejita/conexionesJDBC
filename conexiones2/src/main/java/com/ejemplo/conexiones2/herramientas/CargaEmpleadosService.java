package com.ejemplo.conexiones2.herramientas;

import com.ejemplo.conexiones2.Empleado;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CargaEmpleadosService extends Service<ObservableList<Empleado>>{

	@Override
	protected Task<ObservableList<Empleado>> createTask() {
		// TODO Auto-generated method stub
		return new CargarTask();
	}

}
