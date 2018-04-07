package janosvitez;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Fabian Tamas
 */
public class Janosvitez {
    
    static private String tisztit(String s) {
        String abc = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";
        s = s.toLowerCase();
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (abc.indexOf(c) > -1)
                t += c;
        }
        return t;
    }

    public static void main(String[] args) {
        TreeMap <String, Integer> gyakorisag = new TreeMap<>();
        // beolvasás
        try (Scanner be = new Scanner (new File("janos_vitez.txt"),"utf8")) {
            while (be.hasNext()) {
                String szo = tisztit (be.next());
                if (szo.equals(""))
                    continue;
                Integer db = gyakorisag.get(szo);
                if (db == null)
                    db = 1;
                else
                    db++;
                gyakorisag.put(szo, db);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // kiírás
        for (String szo: gyakorisag.keySet())
            if (gyakorisag.get(szo)>1)
                System.out.println(szo + " " + gyakorisag.get(szo));
    }
    
}
