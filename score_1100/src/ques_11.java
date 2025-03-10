import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_11 {
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
                // https://codeforces.com/problemset/problem/1832/B
                // you can see that the greedy logic that we are thinking about to choose the min 2 or max 1 based on
                // the sum we can not do so now we can do the logic like each of the time we have option to explore the
                // both parts so now trying that path

                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n];
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    sum += arr[i];
                }
                Arrays.sort(arr);

                // so now here
                long ans = findMax(k , 0 , n-1 , arr);

                out.println(sum - ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    private  static  long findMax(int k  , int left , int right , int[] arr){
        if(k == 0){
            return  0;
        }

        long taken_left =  (arr[left] + arr[left+1]) + findMax(k-1 ,left+2 , right , arr );
        long taken_right = (arr[right]) + findMax(k-1 ,left , right-1 , arr );
        return Math.min(taken_right , taken_left);

    }
}
