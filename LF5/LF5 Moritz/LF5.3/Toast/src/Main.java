import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Toaster toaster;


    public static void main(String[] args) {
        System.out.println("Guten Tag!\nMöchten Sie ihren Toaster selbst konfigurieren? (y/n)");
        if(!stringToBool(scanner.nextLine())){
            toaster = new Toaster();
        } else {
            System.out.println("Welche Farbe soll Ihr Toaster haben?");
            String farbe = scanner.nextLine();
            System.out.println("Wie viele Schächte soll Ihr Toaster haben?");
            int schachtAnzahl = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Möchten Sie einen SuperToaster? (y/n)");
            if(stringToBool(scanner.nextLine())){
                toaster = new SuperToaster(farbe, schachtAnzahl);
            } else {
                toaster = new Toaster(farbe, schachtAnzahl);
            }
        }

        while(true){
            System.out.println(command());
            System.out.println();
        }

    }

    private static boolean stringToBool(String str){
        if (str.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    private static String command(){
        String commands = "1: Toasts einlegen\n"
                            + "2: Zeit einstellen\n"
                            + "3: Toasts toasten\n"
                            + "4: Toasts auswerfen\n"
                            + "5: Toaster Informationen erhalten";
        if (toaster instanceof SuperToaster){
            commands += "\n6: Toaster abkühlen lassen";
        }
        System.out.println("Was Möchten Sie tun? Wählen Sie:(Nummer eingeben)\n" + commands);
        switch (scanner.nextInt()){
            case 1: return toastEinlegen();
            case 2: return zeitEinstellen();
            case 3: return toaster.toasten();
            case 4: return toaster.toastAuswerfen();
            case 5: return toaster.toString();
            default: return "Fehler!";
        }
    }

    private static String toastEinlegen(){
        System.out.println("Wie viele Toasts einlegen?");
        return toaster.toastReintun(scanner.nextInt());
    }

    private static String zeitEinstellen(){
        System.out.println("Welche Zeit einstellen?");
        return toaster.zeitEinstellen(scanner.nextInt());
    }
}