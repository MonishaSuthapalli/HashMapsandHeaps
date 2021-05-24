import java.io.*;
import java.util.*;

public class priorityQueueUsingHeap {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upheapify(data.size()-1);
        }

        private void upheapify(int idx)
        {
            if(idx==0)
                return;
            int pi=(idx-1)/2;
            if(data.get(pi)>data.get(idx))
                swap(pi,idx);
            upheapify(pi);

        }

        private void swap(int pi,int idx)
        {
            int getfirst=data.get(pi);
            int getsecond=data.get(idx);
            data.set(pi,getsecond);
            data.set(idx,getfirst);
        }

        public int remove() {
            // write your code here
            if(data.size()==0)
            {
                System.out.println("Underflow");
                return -1;
            }
            else
            {
                swap(0,data.size()-1);

                int val=data.remove(data.size()-1);

                downheapify(0);


                return val;
            }


        }


        private void downheapify(int pi)
        {
            int mini=pi;

            int lc=2*pi+1;
            int rc=2*pi+2;

            if(lc<data.size()&&data.get(lc)<data.get(mini))
            {
                mini=lc;
            }
            if(rc<data.size()&&data.get(rc)<data.get(mini))
            {
                mini=rc;
            }
            if(mini!=pi)
            {
                swap(pi,mini);
                downheapify(mini);
            }

        }

        public int peek() {
            // write your code here
            if(data.size()==0)
            {
                System.out.println("Underflow");
                return -1;
            }
            else
                return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}