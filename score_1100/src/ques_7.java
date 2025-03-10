import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_7 {
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
                long x = in.nextLong();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                Arrays.sort(arr);
                // so now here we have to do the binary search only
                long start = 1;
                long end = Integer.MAX_VALUE; // not taken it as x because in some cases like see 4th the value
                // would be 1000001 but our end will be 10000 so it will never reach

                long ans = Integer.MIN_VALUE;
                while (start <= end){
                    long mid = (start + end)/2;

                    // so now here we will find the value for it
                    long curr = findValue(arr , mid);
                    if(curr > x){
                        end = mid-1;
                    }else{
                        // storing in the answer
                        ans = Math.max(ans , mid);
                        start = mid+1;
                    }
                }

                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static long findValue(int[] arr , long n){
        // so now it will calculate sum of all the number less than n
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= n){
                break;
            }
            sum += (n-arr[i]);
        }
        return sum;
    }
}
