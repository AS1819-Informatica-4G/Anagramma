/**
 * Sample Skeleton for 'AnagrammaView.fxml' Controller Class
 */

package anagramma.gui;

import java.net.URL;
import java.util.ResourceBundle;

import anagramma.model.Anagramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammaController {
    private Anagramma model;
    
    public void setModel(Anagramma model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagramma"
    private Button btnAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultati"
    private TextArea txtRisultati; // Value injected by FXMLLoader

    @FXML // fx:id="txtStatus"
    private TextField txtStatus; // Value injected by FXMLLoader

    @FXML
    void onAnagramma(ActionEvent event) {
    	model.setParola(txtParola.getText());
    	model.processa();
    	txtRisultati.clear();
    	for ( String s : model.getSequenze() ) {
    		txtRisultati.appendText(String.format("%s\n", s));
    	}
    	int nSeq=model.getSequenze().size();
    	txtStatus.setText(String.format("Totale %d sequenz%c",nSeq, ((nSeq==1) ? 'a' : 'e')));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'AnagrammaView.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'AnagrammaView.fxml'.";
        assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'AnagrammaView.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'AnagrammaView.fxml'.";

    }
}
