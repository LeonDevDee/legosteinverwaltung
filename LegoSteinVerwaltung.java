
/**
 * Beschreiben Sie hier die Klasse LegoSteinVerwaltung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LegoSteinVerwaltung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private SteinGateway steingateway;
    private List<Stein> steine;

    /**
     * Konstruktor für Objekte der Klasse LegoSteinVerwaltung
     */
    public LegoSteinVerwaltung()
    {
      steingateway = new SteinGateway();
      steine = new List<Stein>();
  
      
      steine = steingateway.holeAlle();
    }
    /**
     * fügt einen Stein zur Datenbank hinzu
     * @param bez Bezeichnung des gesuchten Steines
     * @param pps Preis pro Stein
     * @param besch Beschreibung des Steins
     * @param anzahl Anzahl der Steine
     * @param kat Kategorie des Steins
     * @return void
     */

    public void fuegeSteinHinzu(String bez, double pps, String besch,int anzahl, String kat )
    {
      Stein stein = new Stein(bez,pps,besch,anzahl,kat);
      steingateway.hinzufügen(stein);
    }
     /**
     * löscht einen Stein aus der Datenbank
     * @param bez Bezeichnung des gesuchten Steines
     * @return void
     */

    public void loescheStein(String bez)
    {
        steingateway.loesche(bez);
    }
     /**
     * sucht einen Stein und speichert diesen als stein
     * @param bez Bezeichnung des gesuchten Steines
    
     * @return void
     */

    public void sucheNachStein(String bez){
        Stein stein = steingateway.hole(bez);
    }
}
