import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host;
        while (true) {
            System.out.println("Hola, por favor escribe el host que quieres saber el ping o 'salir' si quieres terminar el programa.");
            host = sc.nextLine();
            if (host.equals("salir")) {
                System.out.println("Saliendo del programa.");
                sc.close();
                break;
            } else {
                Lanzador lanzador = new Lanzador();
                int resultado = lanzador.devolverPing(host);
                if (resultado == 0) {
                    System.out.println("El host " + host + " es alcanzable.");
                } else {
                    System.out.println("El host " + host + " no es alcanzable.");
                }
            }
        }
    }
}