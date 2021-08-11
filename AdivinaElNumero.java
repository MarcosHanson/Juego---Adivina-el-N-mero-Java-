import java.util.Scanner;

public class AdivinaElNumero {

    private Scanner entrada = new Scanner(System.in);
    private boolean juegoActivo = true;

    public void jugar() {

        String jugador = obtenerNomJugador();

        while (juegoActivo) {
            int intentos = 0;
            int min = 0;
            int max = 30;
            int numeroDelJuego = obtenerNumAleatorio(0, 30);

            System.out.printf("%s, he escogido un numero entre %d y %d, Adivinalo!\n", jugador, min, max);
            int numeroJugador;

            do {
                numeroJugador = escogerNum();
                mensaje(numeroJugador, numeroDelJuego);
                intentos++;
            } while (numeroJugador != numeroDelJuego);

            System.out.printf("¡ FELICITACIONES !, lo lograste en %d intentos\n", intentos);
            System.out.printf("El numero era %d\n", numeroDelJuego);


            juegoActivo = jugarNuevamente();

        }

    }

    private int obtenerNumAleatorio(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private String obtenerNomJugador() {
        System.out.println("cual es tu nombre?");
        String jugador = entrada.nextLine();
        System.out.printf("Hola %s!!!\n", jugador);
        return jugador;
    }

    private int escogerNum() {
        System.out.printf("Escoja un numero");

        return entrada.nextInt();
    }

    private void mensaje(int numeroJugador, int numeroDelJuego) {
        if (numeroJugador < numeroDelJuego) {
            System.out.println("número bajo, escoge otro");

        } else if (numeroJugador > numeroDelJuego) {
            System.out.println("número alto, escoge nuevamente");
        }
    }

    public boolean jugarNuevamente() {
        System.out.println("Quieres seguir jugando?\n 1. SI\n 2. NO");
        int respuesta = entrada.nextInt();
        if (respuesta == 1) {
            return true;
        } else
            System.out.println("Vuelve pronto, ¡Adios!");
        return false;
    }
}
