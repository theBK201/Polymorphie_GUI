
public class Sprint100m extends sportDaten{
    private int sek;
    private int hundertstel;

    public Sprint100m(String n, int s, int h){
        super(n);
        sek = s;
        hundertstel = h;
    }

    @Override
    public String display(){
        return ("Sportler: "+sportlerName+", hat das 100 Metar Sprint mit Zeit "+sek+"."+hundertstel+" abgeschlossen!\n");
    }
}
