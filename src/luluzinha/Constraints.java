package luluzinha;

import javafx.scene.control.TextField;
public class Constraints {
public static void setTextFieldInteger(TextField txt) {
txt.textProperty().addListener((obs, oldValue, newValue) -> {
 if (newValue != null && !newValue.matches("\\d*")) {
 txt.setText(oldValue);
 }
 });
}
public static void setTextFieldMaxLength(TextField txt, int max) {
txt.textProperty().addListener((obs, oldValue, newValue) -> {
 if (newValue != null && newValue.length() > max) {
 txt.setText(oldValue);
 }
 });
}
public static void setTextFieldDouble(TextField txt) {
txt.textProperty().addListener((obs, oldValue, newValue) -> {
 if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
 txt.setText(oldValue);
 }
 });
}

    static void setTextFieldDouble(double valor1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setTextFieldMaxLength(double valor1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
