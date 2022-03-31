
/**
 * Beschreiben Sie hier die Klasse Stein.
 * 
 * @author Leon
 * @version 1
 */
public class Stein
{
    String bezeichnung;
    double preisProStueck;
    String beschreibung;
    int anzahl;
    String kategorie;
    
    /**
     * Konstruktor für einen Stein
     * @param bez Bezeichnung
     * @param pps PreisProStueck
     * @param besch Beschreibung
     * @param anz Anzahl
     * @param kat Kategorie
     */
    public Stein(String bez, double pps, String besch, int anz, String kat)
    {
        bezeichnung = bez;
        preisProStueck = pps;
        beschreibung = besch;
        anzahl = anz;
        kategorie = kat;
    }
    
    /**
     * gibt Bezeichnung zurueck
     */
    public String gibBezeichnung(){
        return bezeichnung;
    }
    
    /**
     * setzt Bezeichnung auf den uebergebenen Wert
     * @param bez neue Bezeichnung
     */
    public void setzeBezeichnung(String bez){
        bezeichnung = bez;
    }
    
    /**
     * gibt den Preis pro Stueck zurueck
     */
    public double gibPreisProStueck(){
        return preisProStueck;
    }
    
    /**
     * setzt den Preis pro Stueck auf den uebergebenen Wert
     * @param pps neuer Preis pro Stueck
     */
    public void setzePreisProStueck(double pps){
        preisProStueck = pps;
    }
    
    /**
     * gibt die Beschreibung des Steines zurueck
     */
    public String gibBeschreibung(){
        return beschreibung;
    }
    
    /**
     * setzt die Beschreibung auf den uebergebenen Wert
     * @param besch neue Beschreibung
     */
    public void setzeBeschreibung(String besch){
        beschreibung = besch;
    }
    
    /**
     * gibt die Kategorie des Steines zurueck
     */
    public String gibKategorie(){
        return kategorie;
    }
    
    /**
     * setzt die Kategorie auf den uebergebenen Wert
     * @param kat neue Kategorie
     */
    public void setzeKategorie(String kat){
        kategorie = kat;
    }
    
    /**
     * gibt die Anzahl der Stuecke vom Stein zurueck
     */
    public int gibAnzahl(){
        return anzahl;
    }
    
    /**
     * setzt die Anzahl auf den übergebenen Wert
     * @param anz Anzahl
     */
    public void setzeAnzahl(int anz){
        anzahl = anz;
    }
}
