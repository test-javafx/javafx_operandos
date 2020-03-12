package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import modelos.Operaciones;

public class OperacionesController {

    @FXML
    private TextField txtOperando1;

    @FXML
    private TextField txtOperando2;

    @FXML
    private RadioButton rdbSuma;

    @FXML
    private RadioButton rdbResta;

    @FXML
    private RadioButton rdbDivision;

    @FXML
    private RadioButton rdbMultiplicacion;

    @FXML
    private TextField txtResultado;

    private ToggleGroup tg;


    public void initialize() {

        this.tg = new ToggleGroup();

        this.rdbSuma.setToggleGroup(this.tg);
        this.rdbResta.setToggleGroup(this.tg);
        this.rdbDivision.setToggleGroup(this.tg);
        this.rdbMultiplicacion.setToggleGroup(this.tg);

    }

    @FXML
    void calcular(ActionEvent event) {

        Toggle selected = this.tg.getSelectedToggle();

        if(selected == null){
            this.mensajeError("Seleccione una operación", Alert.AlertType.INFORMATION);
            return;
        }


        try{

            int operando1 = Integer.parseInt(this.txtOperando1.getText());
            int operando2 = Integer.parseInt(this.txtOperando2.getText());

            Operaciones op = new Operaciones(operando1, operando2);

            if(this.rdbSuma.isSelected()){
                this.txtResultado.setText(String.valueOf(op.suma()));
            }

            if(this.rdbResta.isSelected()){
                this.txtResultado.setText(String.valueOf(op.resta()));
            }

            if(this.rdbMultiplicacion.isSelected()){
                this.txtResultado.setText(String.valueOf(op.multiplicacion()));
            }

            if(this.rdbDivision.isSelected()){

                if(operando2 == 0){
                    this.mensajeError("No se puede dividir entre 0", Alert.AlertType.WARNING);
                    this.txtResultado.setText("");
                }else{
                    this.txtResultado.setText(String.valueOf(op.division()));
                }

            }

        }catch (NumberFormatException e){

            this.mensajeError("Formato de números incorrecto", Alert.AlertType.ERROR);

        }


    }

    private void mensajeError(String mensaje, Alert.AlertType tipo){

        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.showAndWait();

    }

}
