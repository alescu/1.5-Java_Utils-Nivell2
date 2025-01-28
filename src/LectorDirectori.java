import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LectorDirectori {

    private static FileWriter fitxerTxt = null;
    private static BufferedWriter bfFitxerTxt = null;
    private static SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
    private static SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void control(File fitxerInicial, String tab, String directoriFinal, String nomFitxerTxt ) {
        File[] files = fitxerInicial.listFiles();

        String dataFormatada = format.format(new Date());
        try{

            fitxerTxt = new FileWriter(directoriFinal + File.separator + nomFitxerTxt + "_"+dataFormatada+".txt");
            bfFitxerTxt = new BufferedWriter(fitxerTxt);
            recorreDir(files, tab, bfFitxerTxt);

        } catch (IOException e) {
            System.out.println("No s'ha pogut generar el fitxer.");
            throw new RuntimeException(e);
        }finally {
            UtilsDoc.tancarFitxerTxt( fitxerTxt, bfFitxerTxt);
        }
    }
    public static void recorreDir(File[] files, String tab, BufferedWriter bfFitxerTxt ) {

        tab += "   ";
        Arrays.sort(files, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for (File fitxerTemp:files){
            String informacio = null;
            if(fitxerTemp.isDirectory()) {
                informacio = tab + "[D] " + fitxerTemp.getName() +" "+ format2.format(fitxerTemp.lastModified());
                System.out.println(informacio);
                UtilsDoc.escriuEnFitxerTxt(bfFitxerTxt, informacio);
                recorreDir(fitxerTemp.listFiles(), tab, bfFitxerTxt);
            }else{
                informacio = tab + "[F] " + fitxerTemp.getName() +" "+ format2.format(fitxerTemp.lastModified());
                UtilsDoc.escriuEnFitxerTxt(bfFitxerTxt, informacio);
                System.out.println(informacio);
            }
        }
    }

}
