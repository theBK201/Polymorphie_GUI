public class Marathon extends sportDaten{
    private int std;
    private int min;
    private int sek;

    public Marathon(String n, int st, int mn, int se){
        super(n);
         std = st;
         min = mn;
         sek = se;
    }

    @Override
    public String display(){
        return ("Sportler: "+sportlerName+", hat der Marathon mit Zeit: "+std+" "+min+" "+sek+" finishiert!\n");
    }
}
