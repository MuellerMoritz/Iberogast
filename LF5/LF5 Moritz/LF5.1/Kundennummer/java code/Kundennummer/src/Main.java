/**
 *Kundennummer Generator
 *
 *@author  Moritz Müller
 *@date    26.04.22
 *
 */


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWeitere Kundennummern mit Enter generieren.\nZum Stoppen des Programms 'exit' eingeben.\n");
        Scanner scanner = new Scanner(System.in);
        String exit = "";
        while(!exit.equals("exit")){
            System.out.println("Die vergebene Kundennummer ist: " + kundennummerGenerieren());
            exit = scanner.nextLine();
        }
    }

    private static String kundennummerGenerieren(){
        //Object Init
        Random rnd = new Random();  //Zufallsgenerator

        //Variablen Init
        String kundennummer = "KD";
        int quersumme = 0;
        int ziffer;
        boolean ungueltig = true;

        //Logik

        //Kundennummern generieren, bis eine gültige gefunden wurde
        while(ungueltig){
            //Stellen 3 bis 10 generieren
            for(int i = 0; i < 8 ; i++){
                ziffer = rnd.nextInt(10);
                quersumme += ziffer;
                kundennummer += Integer.toString(ziffer);
            }
            //Quersumme überprufen
            if ( 9 < quersumme && quersumme < 100 ){
                //Gültige Kundennummer
                kundennummer += Integer.toString(quersumme);
                ungueltig = false;
                //TODO implement findCustomNumber(kundennummer)
            } else {
                //Ungültige Kundennummer -> ziffern neu generieren
                kundennummer = "KD";
                quersumme = 0;
            }
        }
        //Ausgabe der gültigen Kundennummer
        return kundennummer;
    }
}