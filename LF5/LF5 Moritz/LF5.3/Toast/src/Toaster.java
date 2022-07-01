public class Toaster {

    protected String farbe;
    protected int schachtAnzahl;
    protected int toastZustand = 0;
    protected int toastAnzahl = 0;
    protected int zeit = 0;


    //Default Toaster constructer
    public Toaster(){
        this.farbe = "Weiß";
        this.schachtAnzahl = 2;
    }

    //special Toaster constructer
    public Toaster(String farbe, int schachtAnzahl){
        this.farbe = farbe;
        this.schachtAnzahl = schachtAnzahl;
    }

    //add toasts (resets zustand)
    public String toastReintun(int anzahl){
        try {
            if (toastAnzahl + anzahl <= schachtAnzahl) {
                toastAnzahl += anzahl;
                toastZustand = 0;
                return "Die Toastanzahl beträgt nun " + toastAnzahl + ".";
            } else {
                throw new Exception("Fehler: Es können maximal " + (schachtAnzahl - toastAnzahl) + "weitere Toasts eingelegt werden!");
            }
        } catch (Exception e){
            return e.toString();
        }
    }

    //remove toasts
    public String toastAuswerfen(){
        String str = "Genießen Sie ihre " + toastAnzahl + " " + zustandToString() + "en Toasts.";
        toastAnzahl = 0;
        return str;
    }

    //setZeit
    public String zeitEinstellen(int dauer){
        this.zeit = dauer;
        return "Zeit auf " + zeit + " Sekunden eingestellt.";
    }

    //changes toastZustand depending on zeit
    public String toasten(){
        try {
            if (toastAnzahl <= 0) {
                toastAuswerfen();
                throw new Exception("Fehler: Keine Toasts eingelegt!");
            }
            if (zeit <= 0) {
                //do nothing
            } else if (zeit <= 15) {
                toastZustand += 1;
            } else if (zeit <= 30) {
                toastZustand += 2;
            } else {
                toastZustand += 3;
            }
            return "Fertig. Ihre Toasts sind nun " + zustandToString() + ".";
        } catch (Exception e) {
            return e.toString();
        }
    }

    //converts the current toastZustand into String
    private String zustandToString() {
        switch (toastZustand){
            case 0: return "ungetoastet";
            case 1: return "leicht getoastet";
            case 2: return "stark getoastet";
            default: return "verbrannt";
        }
    }

    public String toString() {
        return "Toaster:\n"
                + "Farbe: " + farbe
                + "\nSchachtanzahl: " + schachtAnzahl
                + "\nZeiteinstellung: " + zeit
                + "\nToastanzahl: " + toastAnzahl
                + "\nToastzustand: " + zustandToString();
    }
}
