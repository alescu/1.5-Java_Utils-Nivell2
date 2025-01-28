import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UtilsDoc {
    private static final String nomFitxerTxt="fitxerRecull";

    public static BufferedWriter crearFitxerTxt(FileWriter fitxerTxt) throws IOException {
        return new BufferedWriter(fitxerTxt);
    }

    public static void escriuEnFitxerTxt(BufferedWriter bufferWrt, String informacio) {
        try{
            bufferWrt.newLine();
            bufferWrt.write(informacio);
            bufferWrt.flush();
        } catch (IOException e) {
            System.out.println(">>>>>  No s'ha pogut guardar la informació: " + informacio);
        }
    }

    public static void tancarFitxerTxt(FileWriter fitxerTxt,BufferedWriter bufferWrt) {
        try{
            if(bufferWrt!=null && fitxerTxt!=null) {
                bufferWrt.flush();
                bufferWrt.close();
                fitxerTxt.close();
            }
        } catch (IOException e) {
            System.out.println("Error tancant els recursos. ");
            System.out.println(e.getMessage());
        }
    }


}
