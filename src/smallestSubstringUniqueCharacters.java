import java.util.*;

public class smallestSubstringUniqueCharacters {

    public static int solution(String str){
        // write your code here

        int len=str.length();
        HashSet<Character> set=new HashSet<>();
        for(char c:str.toCharArray())
        {
            set.add(c);
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int i=-1,j=-1;
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1&&map.size()<set.size())
            {
                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);

                f1=true;
            }

            while(j<i&&map.size()==set.size())
            {
                int pot=i-j;
                if(pot<len)
                    len=pot;

                j++;

                char ch=str.charAt(j);
                if(map.get(ch)==1)
                    map.remove(ch);
                else
                    map.put(ch,map.get(ch)-1);

                f2=true;
            }
            if(f1==false&&f2==false)
                break;

        }


        return len;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
