package laba9;

import java.util.ArrayList;


public class Generator {
    private ArrayList<String> carNumbs ;
    private  char xyz[];
    private  char n[];
    private String r[];

    public Generator()
    {
        carNumbs = null;
        xyz = new char[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        n = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        r = new String [199];
        for(int i=1;i<200;++i)
            r[i-1]=String.format("%02d",i);
    }

    public ArrayList<String> generate(){
        if (carNumbs != null) return carNumbs;
        carNumbs = new ArrayList<String>();
        gen(0,"");
        return carNumbs;
   }
    private void gen(int p,String s){
        if(carNumbs.size() > 10e6) return;
        if(p>6 ){
            carNumbs.add(s);
            return;
        }
        if(p == 0 || p ==4 || p ==5)
            for(char i: xyz)
                gen(p+1,s+i);
        else if( p>0 && p<4)
            for(char i: n)
                gen(p+1,s+i);
        else
            for(String i: r)
                gen(p+1,s+i);
    }

}
