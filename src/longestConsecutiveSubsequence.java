import java.io.*;
import java.util.*;

public class longestConsecutiveSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],true);
        }

        for(int i:arr)
        {
            if(hm.containsKey(i-1))
            {
                hm.put(i,false);
            }
        }

        int ml=0;
        int msp=0;
        for(int i:arr)
        {
            if(hm.get(i)==true)
            {
                int tl=1;
                int tsp=i;
                while(hm.containsKey(tsp+tl)==true)
                {
                    tl++;
                }

                if(tl>ml)
                {
                    ml=tl;
                    msp=tsp;
                }

            }
        }

        for(int i = 0; i < ml; i++){
            System.out.println(msp + i);
        }





    }

}