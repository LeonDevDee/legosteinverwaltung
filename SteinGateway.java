
/**
 * Beschreiben Sie hier die Klasse SteinGateway.
 * 
 * @author Leon 
 * @version 1
 */
public class SteinGateway
{
    private DatabaseConnector db;
    
    public SteinGateway(){
        db = null;
    }
    
    public void verbinde(){
        if(db == null){
            db = new DatabaseConnector("", 0, "legosteine","", "");
        }
    }
    
    public void beende(){
        if(db != null){
            db.close();
            db = null;
        }    
    }
    
    public void erzeugeTabelle(){
        verbinde();
        db.executeStatement("CREATE TABLE IF NOT EXISTS legosteine(bezeichnung SERIAL PRIMARY_KEY, preisProStueck INT, beschreibung VARCHAR(255), kategorie VARCHAR(255))");
        beende();
    }
    
    public Stein hole(String bez){
        verbinde();
        db.executeStatement("SELECT * FROM legosteine WHERE bezeichnung = " + bez);
        QueryResult qr = db.getCurrentQueryResult();
        Stein stein = new Stein(qr.getData()[0][0], qr.getData()[0][1], qr.getData()[0][2],qr.getData()[0][3]);
        beende();
        return stein;
    }
    
}
