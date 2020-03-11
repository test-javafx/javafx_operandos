package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelos.Operaciones;

public class OperacionesController {

    @FXML
    private TextField txtOperando1;

    @FXML
    private TextField txtOperando2;

    @FXML
    private Button btnCalcular;

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


    public void initialize() {

        ToggleGroup tg = new ToggleGroup();

        this.rdbSuma.setToggleGroup(tg);
        this.rdbResta.setToggleGroup(tg);
        this.rdbDivision.setToggleGroup(tg);
        this.rdbMultiplicacion.setToggleGroup(tg);

    }

    @FXML
    void calcular(ActionEvent event) {

        int op1 = Integer.parseInt(this.txtOperando1.getText());
        int op2 = Integer.parseInt(this.txtOperando2.getText());

        Operaciones op = new Operaciones(op1,op2);

    }

}
