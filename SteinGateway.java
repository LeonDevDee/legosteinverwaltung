
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
        Stein stein = new Stein(qr.getData()[0][0], Double.parseDouble(qr.getData()[0][1]), qr.getData()[0][2], Integer.parseInt(qr.getData()[0][3]), qr.getData()[0][4]);
        beende();
        return stein;
    }
    /**
     * Gibt eine Liste mit allen Steinen zurück
     * 
     * @return eine Liste mit allen Steinen
     */

    public List<Stein> holeAlle(){
         verbinde();
        db.executeStatement("SELECT * FROM legosteine" );
        QueryResult qr = db.getCurrentQueryResult();
        List<Stein> steine = new List<Stein>();
        
        for(int i = 0; i < qr.getColumnCount(); i++)
        {
         steine.append(new Stein(qr.getData()[i][0], Double.parseDouble(qr.getData()[i][1]), qr.getData()[i][2], Integer.parseInt(qr.getData()[i][3]), qr.getData()[i][4])); 
        }
        
        beende();
        return steine;
    }
    /**
     * fügt einen Stein hinzu
     * @param s übergebener Stein
     * @return void
     */
    public void hinzufügen(Stein s){
        verbinde();
        db.executeStatement("INSERT INTO legosteine " + "VALUES ( '" + s.gibBezeichnung() + "' ," + s.gibPreisProStueck() +", '" + s.gibBeschreibung()+ "', '" + s.gibKategorie()+ "', " + s.gibAnzahl() +  "" );
        beende();          
    }
    
    /**
     * löscht den Stein mit der entsprechenden Bezeichnung
     * @param Bezeichnung Bezeichnung des gesuchten Steines
     * @return void
     */
    public void loesche(String Bezeichnung){
        verbinde();
        db.executeStatement("DELETE FROM legosteine WHERE bezeichnung = " + Bezeichnung);  
        beende();  
    }
    
    
   
    
    
    }
    
    

