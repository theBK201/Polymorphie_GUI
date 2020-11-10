
public class Sprint100m extends sportData {
    private int sec;
    private int hundredth;

    public Sprint100m(String n, int s, int h){
        super(n);
        sec = s;
        hundredth = h;
    }

    @Override
    public String display(){
        return ("Sportler: "+athleteName+", hat das 100 Metar Sprint mit Zeit "+sec+"."+hundredth+" abgeschlossen!\n");
    }
}
