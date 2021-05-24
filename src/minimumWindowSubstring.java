import java.util.*;

public class minimumWindowSubstring {
    static String ans="";
    static String pot="";
    public static String solution(String s1, String s2){
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char i:s2.toCharArray())
        {
            map2.put(i,map2.getOrDefault(i,0)+1);
        }

        HashMap<Character,Integer> map1=new HashMap<>();
        int i=-1;
        int j=-1;
        int matchCount=0;
        int desiredCount=s2.length();
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            //acquire
            while(i<s1.length()-1&&matchCount<desiredCount)
            {
                i++;
                char ch=s1.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0))
                {
                    matchCount++;
                }
                f1=true;
            }
            int minAns=Integer.MAX_VALUE;
            pot="";

            while(j<i&&matchCount==desiredCount)
            {
                String pans=s1.substring(j+1,i+1);
                if(ans.length()==0||pans.length()<ans.length())
                {
                    ans=pans;

                }
                j++;
                char ch=s1.charAt(j);
                if(map1.get(ch)==1)
                    map1.remove(ch);
                else
                    map1.put(ch,map1.get(ch)-1);

                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
                {
                    matchCount--;
                }

                f2=true;
            }

            if(f1==false&&f2==false)
                break;



        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }

}
