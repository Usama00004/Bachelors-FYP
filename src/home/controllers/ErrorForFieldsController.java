package home.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ErrorForFieldsController implements Initializable {



@FXML
private Button btn_Error;

@FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {


            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      }


    }
