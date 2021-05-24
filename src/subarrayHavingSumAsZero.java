import java.util.*;

public class subarrayHavingSumAsZero {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int max=0;
        int sum=0;
        int i=-1;
        hm.put(sum,i);


        while(i<arr.length-1)
        {

            i++;
            sum=sum+arr[i];
            if(hm.containsKey(sum)==false)
            {
                hm.put(sum,i);
            }
            else
            {
                int val=i-hm.get(sum);
                if(val>max)
                    max=val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
