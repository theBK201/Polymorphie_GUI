
public class sportData {
    protected String athleteName;
    protected String line = "----------------";

    public sportData(String n){
        athleteName = n;
    }


     String display(){
        return "ready for override";
    }
}
