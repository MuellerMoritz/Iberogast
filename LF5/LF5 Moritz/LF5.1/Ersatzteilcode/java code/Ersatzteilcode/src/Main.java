/**
 *Ersatzteilcode Test
 *
 *@author  Moritz Müller
 *@date     28.04.22
 *
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ersatzteilcode: ");
        String ersatzteilcode = scanner.nextLine();
        while(!ersatzteilcode.equals("exit")){
            System.out.println(checkCode(ersatzteilcode));
            System.out.print("\nZum Stoppen des Programms 'exit' eingeben.\nErsatzteilcode: ");
            ersatzteilcode = scanner.nextLine();
        }
    }

    public static String checkCode(String ersatzteilcode){
        //überprüfen, ob nur Ziffern enthalten sind
        if (ersatzteilcode.matches("[0-9]+")){
            try {
                //Gewicht überprüfen
                int nettogewicht = Integer.parseInt(ersatzteilcode.substring(9,15));
                int bruttogewicht = Integer.parseInt(ersatzteilcode.substring(19,25));
                if (nettogewicht <= bruttogewicht){
                    //Ersatzteilcode ist korrekt
                    return "Fehlercode 0";
                } else {
                    //Gewicht kann nicht stimmen
                    return "Fehlercode 2";
                }
            }
            catch (Exception e){
                //Fehler bei zu kurzem Code abfangen
                return "Ersatzteilcode konnte nicht verarbeitet werden ("+ e +")";
            }
        } else {
            //Nicht nur Ziffern
            return "Fehlercode 1";
        }
    }
}