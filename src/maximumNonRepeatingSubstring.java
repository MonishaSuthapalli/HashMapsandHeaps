import java.util.*;

public class maximumNonRepeatingSubstring {

    public static int solution(String str) {
        // write your code here
        int i=-1;
        int j=-1;
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1)
            {

                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2)
                    break;
                else
                {
                    int pot=i-j;
                    if(len<pot)
                        len=pot;
                }
                f1=true;
            }
            while(j<i)
            {
                f2=true;
                j++;
                char ch=str.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==1)
                    break;



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
