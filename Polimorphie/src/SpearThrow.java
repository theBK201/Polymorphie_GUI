public class SpearThrow extends sportData {
    private double distance;

    public SpearThrow(String n, double w){
        super(n);
        distance = w;
    }

    @Override
    public String display(){
        return ("Sportler: "+athleteName+", hat das Speer "+distance+" gewurfen.\n");
    }
}
