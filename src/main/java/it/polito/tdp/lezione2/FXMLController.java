package it.polito.tdp.lezione2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private int NtentativiFatti, numeroSegreto, TMax, NMax;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNuovaPartita;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtCom;

    @FXML
    private TextField txtNmax;

    @FXML
    private TextField txtProva;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private TextField txtTentativi;

    @FXML
    private TextField txtTmax;
    
    @FXML
    private ProgressBar barTentativi;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	this.btnProva.setDisable(false);
    	this.txtRisultato.clear();
    	this.txtTentativi.clear();
    	this.txtCom.clear();
    	this.barTentativi.setProgress(0.0);
    	
    	this.NtentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax + 1);
    	try {
    		this.TMax = Integer.parseInt(this.txtTmax.getText());
    	}catch (NumberFormatException e) {
    		this.txtCom.setText("TMax deve essere un numero!");
    	}
    	
    	try {
        	this.NMax = Integer.parseInt(this.txtNmax.getText());
        	}catch (NumberFormatException e) {
        		this.txtCom.setText("NMax deve essere un numero!");
        	}
    	this.txtTentativi.setText(Integer.toString(this.TMax - this.NtentativiFatti));
    	this.txtNmax.setText(Integer.toString(this.NMax));
    	this.txtTmax.setText(Integer.toString(this.TMax));

    }

    @FXML
    void doProva(ActionEvent event) {
    	this.txtCom.setText("");

    	int guess;
    	try {
    		guess = Integer.parseInt(txtProva.getText()); 
    	}catch  (NumberFormatException e){
    		this.txtCom.setText("Inserire un numero");
    		return;
    	}
    	this.NtentativiFatti++;
    	txtTentativi.setText(Integer.toString(this.TMax - this.NtentativiFatti));
    	this.barTentativi.setProgress((double) this.NtentativiFatti / this.TMax);
    	if(guess == this.numeroSegreto) {
    		this.txtRisultato.appendText("Hai vinto. Il numero segreto era " + this.numeroSegreto);
    		this.btnProva.setDisable(true);
    		return;
    	}
    	if(this.NtentativiFatti == this.NMax) {
    		txtRisultato.setText("Hai perso. Il numero segreto era " + this.numeroSegreto);
    		this.btnProva.setDisable(true);

    		return;
    	}
    		
    	if(guess > this.numeroSegreto) {
    		this.txtRisultato.appendText("Il numero è troppo alto \n");
    		return;
    	}else {
    		this.txtRisultato.appendText("Il numero è troppo basso \n");
    		return;
    	}

    }

    @FXML
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNmax != null : "fx:id=\"txtNMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTmax != null : "fx:id=\"txtTmax\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

