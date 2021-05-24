import java.util.*;

public class iternary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        HashMap<String,Boolean> potential=new HashMap<>();
        for(String val:map.keySet())
        {
            String dest=map.get(val);
            potential.put(dest,false);
            if(potential.containsKey(val)==false)
            {
                potential.put(val,true);

            }

        }



        String pot="";
        for(String src:potential.keySet())
        {
            if(potential.get(src)==true)
                pot=src;

        }

        while(true)
        {
            if(map.containsKey(pot)){
                System.out.print(pot+" -> ");
                pot=map.get(pot);
            }
            else
            {
                System.out.print(pot+".");
                break;
            }
        }


    }
}
