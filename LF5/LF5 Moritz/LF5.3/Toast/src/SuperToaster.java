public class SuperToaster extends Toaster{
    private int temperatur = 25;

    public SuperToaster(String farbe, int schachtAnzahl){
        super(farbe, schachtAnzahl);
    }

    @Override
    public String toasten() {
        temperatur += zeit * 10;
        if (temperatur >= 500){
            toastZustand = 3;
            return "Fehler: Toaster ist zu heiß geworden. Bitte abkühlen lassen";
        } else {
            return super.toasten();
        }
    }

    public String abkühlen(){
        temperatur = 20;
        return "Der Toaster ist nun wieder abgekühlt.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nTemperatur: " + temperatur;
    }
}
