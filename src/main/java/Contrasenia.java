import java.util.Locale;

import static java.lang.Character.*;

public class Contrasenia {

    //Atributos

    private String largo;

    //Constructor

    public Contrasenia() {

    }

    public Contrasenia(String largo) {
        this.largo = largo;
    }

    //Setter y Getter
    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }
}
