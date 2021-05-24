import java.util.*;

public class countSubstringLengthKhavingKdistinct {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str,k));
    }

    public static int solution(String str, int K){
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        if(map.size()==K)
            count++;

        for(int i=K;i<str.length()-1;i++)
        {
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);


            ch=str.charAt(i-K);
            if(map.get(ch)==0)
                map.remove(ch);
            else
                map.put(ch,map.getOrDefault(ch,0)+1);


            if(map.size()==K)
                count++;

        }

        return count;

    }

}