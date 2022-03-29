
/**
 * Beschreiben Sie hier die Klasse SteinGateway.
 * 
 * @author Leon 
 * @version 1
 */
public class SteinGateway
{
    private DatabaseConnector db;
    
    /**
     * Konstruktor für den Steingateway
     */
    public SteinGateway(){
        db = null;
    }
    
    /**
     * Methode zur Verbindung des Programms mit der Datenbank
     */
    public void verbinde(){
        if(db == null){
            db = new DatabaseConnector("", 0, "legosteine","", "");
        }
    }
    
    /**
     * Methode zur Trennung des Programms mit der Datenbank
     */
    public void beende(){
        if(db != null){
            db.close();
            db = null;
        }    
    }
    
    /**
     * Erzeugung der Tabelle falls sie noch nicht existiert
     */
    public void erzeugeTabelle(){
        verbinde();
        db.executeStatement("CREATE TABLE IF NOT EXISTS legosteine(bezeichnung SERIAL PRIMARY_KEY, preisProStueck DOUBLE, beschreibung VARCHAR(255), anzahl INT, kategorie VARCHAR(255))");
        beende();
    }
    
    /**
     * Gibt den Stein mit der gegebnen Bezichnung zurück
     * @param bez Bezeichnung des gesuchten Steines
     * @return den Stein, mit der entsprechenden Bezeichnung
     */
    public Stein hole(String bez){
        verbinde();
        db.executeStatement("SELECT * FROM legosteine WHERE bezeichnung = " + bez);
        QueryResult qr = db.getCurrentQueryResult();
        Stein stein = new Stein(qr.getData()[0][0], qr.getData()[0][1], qr.getData()[0][2],qr.getData()[0][3]);
        beende();
        return stein;
    }
    
}
