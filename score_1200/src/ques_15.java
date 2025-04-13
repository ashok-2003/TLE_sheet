import java.io.*;
import java.util.StringTokenizer;

public class ques_15 {
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
            while(testCases-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                long sum = 0;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    sum += arr[i];
                }
                if (sum < k) {
                    out.println(-1);
                    continue;
                }

                // so now here we have to use the recursion call here

                int ans = recursion(arr , 0  , n-1 , k , sum);
                out.println(ans);


            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  int recursion (int[] arr , int i , int j , int target , long curr){
        if(curr == target){
            return 0;
        }
        // so now here we have to check in each of the case here
        int left = 1+ recursion(arr , i+1 , j , target , curr - arr[i]);
        int right = 1+ recursion(arr , i , j-1 , target , curr - arr[j]);
        return Math.min(left , right);
    }
}
