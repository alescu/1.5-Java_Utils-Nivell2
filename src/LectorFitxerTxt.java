import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorFitxerTxt {

    public static void llegirTxt(File fitxerTxt){
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fitxerTxt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
