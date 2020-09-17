package ru.vk.sladkiipirojok;

import javafx.beans.value.ObservableValue;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;





public class Controller {
    private static final String DNKPATTERN ="[^TGCA\n]";
    private static final String RNKPATTERN ="[^UGCA\n]";


    private boolean isDNK = false;

    @FXML
    private CheckBox isDNKBox;


    @FXML
    private Label A;

    @FXML
    private Label C;

    @FXML
    private Label UT;

    @FXML
    private Label G;


    @FXML
    private Label clearButton;

    @FXML
    private TextArea sequenceField;



    @FXML
    void changedText(ObservableValue observable, String oldValue, String newValue) {
        String sequence = sequenceField.getText().toUpperCase();

        if(isDNK) {
            sequence = sequence.replaceAll(DNKPATTERN, "");
        } else {
            sequence = sequence.replaceAll(RNKPATTERN, "");
        }
       
       
        sequenceField.setText(sequence);
        
        sequence = sequence.replaceAll("\n", "");
        
        setDisable(sequence.length());
        
        
        
        Label[]  labels = new Label[] {A,C,G, UT};
        String[] labelsMark = new String[] {"A","C","G",changedUT(isDNK)};
        
        
        int initSize = sequence.length();;
        int size;
        for(int i = 0 ; i< labels.length; i++) {
        	size = sequence.length();
        	sequence = sequence.replaceAll(labelsMark[i], "");
        	labels[i].setText(labelsMark[i]+": " + (size - sequence.length())  + " ("+String.format("%.2f", percent((size - sequence.length()),initSize))+"%)");
        }
        
    }

    @FXML
    void clickClearScreen(MouseEvent event) {
        A.setText( "A: 0 (0.00%)");
        C.setText( "C: 0 (0.00%)");
        G.setText( "G: 0 (0.00%)");
        UT.setText(changedUT(isDNK)+": 0 (0.00%)");
        sequenceField.clear();
    }

    @FXML
    void isDNKStateChanged(MouseEvent event) {
        isDNK = isDNKBox.isSelected();
        UT.setText(changedUT(isDNK)+": 0 (0.00%)");
    }

    private String changedUT(boolean isDNK) {
    	return (isDNK)?"T":"U";
    }

    private double percent(int quantity, int fullQuantity) {
    	return (fullQuantity==0)? 0: quantity/((double)fullQuantity)*100;
    }

    private void setDisable(int length) {
    	 if(length!=0) {
             isDNKBox.setDisable(true);
         } else {
             isDNKBox.setDisable(false);
         }
    }

}
