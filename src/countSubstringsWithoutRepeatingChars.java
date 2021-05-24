import java.util.*;

public class countSubstringsWithoutRepeatingChars {

    public static int solution(String str) {
        // write your code herein
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1)
            {
                f1=true;
                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(map.get(ch)>1)
                    break;
                else
                    ans=ans+(i-j);
            }

            while(j<i)
            {

                f2=true;
                j++;
                char ch=str.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);

                if(map.get(ch)==1)
                {
                    ans=ans+(i-j);
                    break;
                }



            }

            if(f1==false&&f2==false)
                break;

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
