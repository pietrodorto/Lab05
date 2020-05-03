/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model = new Model() ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagramma"
    private Button btnAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultCorrect"
    private TextArea txtResultCorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultWrong"
    private TextArea txtResultWrong; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	txtResultWrong.clear();
    	txtResultCorrect.clear();
    	
    	if(parola.length()<2) {
    		txtResultWrong.appendText("parola troppo corta");
        	txtResultCorrect.appendText("parola troppo corta");
        	return;
    	}
    	
    	if(parola.length()>8) {
    		txtResultWrong.appendText("parola troppo lunga");
        	txtResultCorrect.appendText("parola troppo lunga");
        	return;
    	}
    	
    	Set<String> risultato = this.model.anagrammi(parola);
    	
    	for(String s : risultato) {
    		if(this.model.isCorrect(s)) {
    			txtResultCorrect.appendText(s);
    		}
    		else {
    			txtResultWrong.appendText(s);
    		}
    	}
    			

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtResultWrong.clear();
    	txtResultCorrect.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorrect != null : "fx:id=\"txtResultCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultWrong != null : "fx:id=\"txtResultWrong\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    /*
    public void setModel(Model model) {
    	this.model = model;
    	}
    	*/
}
