package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Main {

    public static void main(String[] args) {
        Restaurante churras = new Restaurante(2, 0, 4, 0, 0, 0);
        Menu menu = new Menu(2, 0, 4, 0, 0, 0); // mesmo construtor de restaurante

        menu.menu();

    }
}
