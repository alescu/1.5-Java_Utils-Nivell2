import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * NIVELL 1
 * - Exercici 1
 *      Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.
 * - Exercici 2
 *      Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris
 *      amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla
 *      en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F),
 *      i la seva última data de modificació.
 * - Exercici 3
 *      Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.
 *
 * Exercici 1 NIVELL 2
 *  Executa l'exercici 3 del nivell anterior parametritzant tots els mètodes en un fitxer de configuració.
 *
 *  Pots utilitzar un fitxer Java Properties, o bé la llibreria Apache Commons Configuration si ho prefereixes.
 *
 *  De l'exercici anterior, parametritza el següent:
 *              Directori a llegir.
 *              Nom i directori del fitxer TXT resultant.
 *
 */
public class Main {
    public static void main(String[] args){

        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("src/resources/infoprojecte.properties")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String directoriOrigen = props.getProperty("directoriOrigen");
        String directoriFinal = props.getProperty("directoriFinal");
        String nomFitxerResultant = props.getProperty("nomFitxerResultant");

        if(!directoriFinal.endsWith(File.separator)){
            directoriFinal += File.separator;
        }

        File file = new File(directoriOrigen);
        if(!file.exists() || !file.isDirectory()){
            System.out.println("No és un directori d'origen vàlid o no existeix.");
            System.out.println("El caràcter separador ha de ser " + File.separator);
            System.out.println("El directori ha d'existir.");
            return;
        }

        file = new File(directoriFinal);
        if(!file.exists() || !file.isDirectory()){
            System.out.println("No és un directori final vàlid o no existeix.");
            System.out.println("El caràcter separador ha de ser " + File.separator);
            System.out.println("El directori ha d'existir.");
            return;
        }


        File fitxerInicial = new File(directoriOrigen);

        // Exercicis 1, 2 i 3
        if(fitxerInicial.isDirectory()){
            LectorDirectori.control(fitxerInicial, "  ", directoriFinal, nomFitxerResultant);
        }else{
            System.out.println("El fitxer no té un format correcte.");
        }

    }

}
