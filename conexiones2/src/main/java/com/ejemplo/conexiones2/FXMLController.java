package com.ejemplo.conexiones2;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ejemplo.conexiones2.herramientas.CargaEmpleadosService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class FXMLController implements Initializable {
    
	@FXML
    private TableColumn apellido;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private TableColumn id;

    @FXML
    private TableColumn nombre;

    @FXML
    private TableView tabla;

    
    @FXML
    private void btnClickAction(ActionEvent event) {
        final CargaEmpleadosService service = new CargaEmpleadosService();
        Region region = new Region();
        region.setStyle("-fx-background-color: rgba(0,0,0, 0.5);");
        region.setPrefSize(500, 300);
        //Indicador de grogreso
        ProgressIndicator p = new ProgressIndicator();
        p.setMaxSize(200, 200);
        p.setTranslateX(50);
        p.setTranslateY(50);
        p.setStyle("-fx-progress-color: #00FF00");
        
        p.progressProperty().bind(service.progressProperty());
        region.visibleProperty().bind(service.runningProperty());
        p.visibleProperty().bind(service.runningProperty());
        
        tabla.itemsProperty().bind(service.valueProperty());
        
        contenedor.getChildren().addAll(region, p);
        
        service.start();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory("id"));
        nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory("apellido"));
    }    
}
