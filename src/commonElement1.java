import java.io.*;
import java.util.*;

public class commonElement1 {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();

        int[] arr1=new int[n1];
        for(int i=0;i<arr1.length;i++)
            arr1[i]=sc.nextInt();
        int n2=sc.nextInt();
        int[] arr2=new int[n2];
        for(int i=0;i<arr2.length;i++)
            arr2[i]=sc.nextInt();

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr1)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.getOrDefault(i,0)+1);
            }else
            {
                map.put(i,1);
            }
        }

        for(int i:arr2)
        {
            if(map.containsKey(i))
            {
                System.out.println(i);
                map.remove(i);
            }
        }

    }

}