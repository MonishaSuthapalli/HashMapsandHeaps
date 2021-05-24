import java.io.*;
import java.util.*;

public class kLargest {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            if(i<k)
            {
                q.add(arr[i]);
            }
            else
            {
                if(q.peek()<arr[i])
                {
                    q.remove();
                    q.add(arr[i]);
                }
            }
        }
        while(q.size()>0)
            System.out.println(q.remove());



    }

}