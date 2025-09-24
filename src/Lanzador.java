import java.io.IOException;
public class Lanzador {
    public static int devolverPing(String host) {

        ProcessBuilder pb = new ProcessBuilder("ping","-c","4", host);
        pb.inheritIO();
        try {
            Process p = pb.start();
            int codSalida = p.waitFor();

            //BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //String linea;
            //while ((linea = rd.readLine()) != null){
              /*  System.out.println("Aqui deberia imprimir el ping si entra aqui");
                System.out.println(linea);*/
            return codSalida;
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            return -1;
        }
    }
}