import java.util.*;

public class countOfSubstringsWithKdistinct {

    public static int solution(String str, int k){
        // write your code here
        if(k==1)
            return solutionfork1(str);


        int ans=0;
        HashMap<Character,Integer> mapB=new HashMap<>();
        HashMap<Character,Integer> mapS=new HashMap<>();
        int iS=-1;
        int iB=-1;
        int j=-1;

        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            boolean f3=false;
            while(iB<str.length()-1)
            {
                f1=true;
                iB++;
                char ch=str.charAt(iB);
                mapB.put(ch,mapB.getOrDefault(ch,0)+1);


                if(mapB.size()==k+1)
                {
                    removeChar(mapB,ch);
                    iB--;
                    break;
                }



            }

            while(iS<iB)
            {
                f2=true;
                iS++;
                char ch=str.charAt(iS);
                mapS.put(ch,mapS.getOrDefault(ch,0)+1);

                if(mapS.size()==k)
                {
                    removeChar(mapS,ch);
                    iS--;
                    break;
                }

            }


            while(j<iS)
            {
                f3=true;

                if(mapB.size()==k&&mapS.size()==k-1)
                {
                    ans=ans+iB-iS;
                }

                j++;

                char ch=str.charAt(j);
                removeChar(mapS,ch);
                removeChar(mapB,ch);



                if(mapS.size()<k-1&&mapB.size()<k)
                {
                    break;
                }


            }

            if(f1==false&&f2==false&&f3==false)
                break;

        }

        return ans;
    }

    public static void removeChar(HashMap<Character,Integer> map,char ch)
    {
        if(map.get(ch)==1)
            map.remove(ch);
        else
            map.put(ch,map.get(ch)-1);
    }

    public static int solutionfork1(String str)
    {
        int ans=0;
        int i=-1;
        int j=-1;
        HashMap<Character,Integer> map=new HashMap<>();
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

                if(map.size()==2)
                {
                    removeChar(map,ch);
                    i--;
                    break;
                }
            }

            while(j<i)
            {
                f2=true;
                if(map.size()==1)
                    ans=ans+(i-j);

                j++;
                char ch=str.charAt(j);
                removeChar(map,ch);
                if(map.size()==0)
                    break;
            }
            if(f1==false&&f2==false)
                break;
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str,k));
    }

}
