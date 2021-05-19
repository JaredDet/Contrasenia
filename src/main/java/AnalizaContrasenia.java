import java.util.Locale;

import static java.lang.Character.*;

public class AnalizaContrasenia {

    //Atributo

    private String estado;
    private Contrasenia contrasenia;

    //Constructor

    public AnalizaContrasenia(Contrasenia contrasenia) {
        this.contrasenia = contrasenia;
        analizarEstado();
    }

    //Metodos

    public boolean contenerDigito(int i) {

        return isDigit(contrasenia.getLargo().charAt(i));
    }

    public boolean contenerSpeCarac(int i) {

        return !isLetter(contrasenia.getLargo().charAt(i)) && !isDigit(contrasenia.getLargo().charAt(i));
    }

    public void analizarEstado() {

        int digito = 0;
        int specarac = 0;

        for (int i = 0; i < contrasenia.getLargo().length(); i++) {

            if (contenerDigito(i)) {

                digito++;
            }
            if (contenerSpeCarac(i)) {

                specarac++;
            }
        }

        if (contrasenia.getLargo().length() < 8) {

            System.err.println("Muy corta");
            estado = "Contraseña insegura";
            return;
        }

        if (specarac != 0) {

            System.err.println("Solo caracteres alfanuméricos");
            estado = "";
            return;
        }

        if (digito == 0) {

            System.err.println("Faltan números");
            estado = "Contraseña moderada";
        }
            else if (contrasenia.getLargo().equals(contrasenia.getLargo().toString().toUpperCase())){

                System.err.println("Faltan minúsculas");
                estado = "Contraseña moderada";
            }

            else if (contrasenia.getLargo().equals(contrasenia.getLargo().toString().toLowerCase())){

                System.err.println("Faltan mayúsculas");
                estado = "Contraseña moderada";
            }
            else {
                estado = "Contraseña segura";
            }
    }

    //Getter

    public String getEstado() {
        return estado;
    }
}
