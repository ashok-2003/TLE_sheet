import java.io.*;
import java.util.StringTokenizer;

public class ques_2 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            Main.FastReader in=new Main.FastReader();
            Main.FastWriter out = new Main.FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arrFirst = new int[n];
                int[] arrSecond = new int[n];
                for (int i = 0; i < n; i++) {
                    arrFirst[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    arrSecond[i] = in.nextInt();
                }



                // so we have to solve this problem using the recursion only
                // we have to get the first step always

                // this was the recursion solution of problem
//                int ans = arrFirst[0];
//                k--;
//                ans += findMax(k , arrFirst , arrSecond , 0);
//                out.println(ans);



                // so this problem can be solved using the greedy also we can only use that level if it's
                // all previous all completed and we can use the b for the remaining values
                int final_ans = 0;
                int sum = 0;
                int max_b = 0;
                for(int i = 0; i <  Math.min(n,k); i++){ // loop run till the min of n and k only as we have only that
                    // option and their is noting like what if better solution present later as we have to complete
                    //each of the level
                    max_b = Math.max(max_b , arrSecond[i]);
                    // so now for adding this level the all previous level should be completed so now
                    sum += arrFirst[i];
                    final_ans = Math.max(final_ans , sum + (k-i-1)*max_b);
                }
                out.println(final_ans);


            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static int findMax(int k , int[] arrFirst , int[]arrSecond , int index){
        if(k == 0 || index >= arrFirst.length){
            return 0;
        }
        // so now here we have two value like we can choose the value of next index or we can choose the
        // value of the same index
        int first = arrSecond[index] + findMax(k-1 , arrFirst , arrSecond , index);
        int second = 0;
        if(index+1 < arrFirst.length) {
            second = arrFirst[index + 1] + findMax(k - 1, arrFirst, arrSecond, index + 1);
        }
        return Math.max(first , second);
    }
}
