public class Marathon extends sportData {
    private int hours;
    private int min;
    private int sec;

    public Marathon(String n, int h, int mn, int se){
        super(n);
         hours = h;
         min = mn;
         sec = se;
    }

    @Override
    public String display(){
        return ("Sportler: "+athleteName+", hat der Marathon mit Zeit: "+hours+" "+min+" "+sec+" finishiert!\n");
    }
}
