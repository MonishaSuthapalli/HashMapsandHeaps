import java.io.*;
import java.util.*;

public class maximumFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            else
            {
                map.put(ch,1);
            }
        }

        System.out.println(map.keySet());
        char mf=s.charAt(0);
        for(Character key:map.keySet())
        {
            if(map.get(key)>map.get(mf))
                mf=key;
        }

        System.out.println(mf);

    }

}