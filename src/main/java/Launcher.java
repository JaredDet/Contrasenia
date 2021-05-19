public class Launcher {

    public static void main(String[] args) {

        Contrasenia javier = new Contrasenia("A5kasdskk4_jfd");
        AnalizaContrasenia analizador = new AnalizaContrasenia(javier);
        System.out.println(analizador.getEstado());
    }
}
