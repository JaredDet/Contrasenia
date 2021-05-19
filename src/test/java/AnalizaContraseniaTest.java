import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalizaContraseniaTest {

    Contrasenia contrasenia;

    @BeforeEach
    void setUp() {

        contrasenia = new Contrasenia();
    }

    @Test
    @DisplayName("Test para contraseñas de largo menor a 8")
    void contraseniaCorta() {

        contrasenia.setLargo("4asjas");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña insegura", analizador.getEstado());
    }

    @Test
    @DisplayName("Test para contraseñas sin minúsculas")
    void contraseniaSinMinusculas() {

        contrasenia.setLargo("JASJSJASJASJAS4");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña moderada", analizador.getEstado());
    }

    @Test
    @DisplayName("Test para contraseñas sin mayúsculas")
    void contraseniaSinMayusculas() {

        contrasenia.setLargo("jasdjsdjsdjsd4");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña moderada", analizador.getEstado());
    }

    @Test
    @DisplayName("Test para contraseñas sin números")
    void contraseniaSinDigito() {

        contrasenia.setLargo("JAJSDJSasksakas");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña moderada", analizador.getEstado());
    }

    @Test
    @DisplayName("Test para contraseñas con caracteres especiales")
    void contraseniaSpecar() {

        contrasenia.setLargo("jadasjs@#$");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("", analizador.getEstado());
    }


    @Test
    @DisplayName("Test para contraseñas vacías")
    void contraseniaVacia() {

        contrasenia.setLargo("");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña insegura", analizador.getEstado());
    }

    @Test
    @DisplayName("Test para contraseñas seguras")
    void contraseniaSegura() {

        contrasenia.setLargo("H0l4S0yUn4C0ntr4s3n4aS3gur4");
        AnalizaContrasenia analizador = new AnalizaContrasenia(contrasenia);
        assertEquals("Contraseña segura", analizador.getEstado());
    }
}