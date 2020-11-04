
public class sportDaten {
    protected String sportlerName;
    protected String line = "----------------";

    public sportDaten(String n){
        sportlerName = n;
    }


     String display(){
        return "ready for override";
    }
}
