import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {
    public static int devolverPing(String host) throws IOException, InterruptedException {

        System.out.print("Iniciando ping a " + host + " en " + devolverOS() + "... ");
        ProcessBuilder pb;
        if (devolverOS().equals("Windows")) {
            pb = new ProcessBuilder("ping","-n","4", host);
        } else {
            pb = new ProcessBuilder("ping","-c","4", host);
        }

        Process p = pb.start();
        /*
        Esto solo se utiliza si queremos que el proceso hijo herede la entrada y salida del proceso padre
        pb.inheritIO().command();
         */
        BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null && ((!linea.toLowerCase().contains("no se pudo encontrar el host")) || (!linea.toLowerCase().contains("could not find host")))) {

            System.out.println("[OK]: " + linea);
        }
        int codSalida = p.waitFor();
        if (codSalida != 0) {
            BufferedReader errReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String errLine;
            while ((errLine = errReader.readLine()) != null) {
                System.out.println("[ERROR]: " + errLine);
            }
            return -1;
        }

        return codSalida;
    }

    public static String devolverOS(){
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            return "Windows";
        } else {
            return "Unix-like";
        }

    }
}