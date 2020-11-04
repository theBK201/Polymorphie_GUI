public class SpeerWurf extends sportDaten {
    private double Weite;

    public SpeerWurf(String n, double w){
        super(n);
        Weite = w;
    }

    @Override
    public String display(){
        return ("Sportler: "+sportlerName+", hat das Speer "+Weite+" gewurfen.\n");
    }
}
