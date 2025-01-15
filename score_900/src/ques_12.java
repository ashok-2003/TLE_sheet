import java.io.*;
import java.util.StringTokenizer;

public class ques_12 {
//    https://codeforces.com/problemset/problem/1726/A
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
                // so now their are three ways in which we can find the value
                // either get the start - max value
                // either get the end - min value
                // either get the one one less value
                // as here for the answer lower number should have lesser index than heigher number to roatate
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                if(n == 1){
                    out.println(0);
                    continue;
                }
                // so now here we have get the max and min value here
                int ans = Integer.MIN_VALUE;
                for(int i = 1; i < n; i++){
                    ans = Math.max(arr[i-1] - arr[i] , ans); // due to anti clockwise rotation
                }
                // so now here we have to get the max
                for (int i = 1; i < n; ++i) {
                    ans = Math.max(ans, arr[i] - arr[0]);
                }

                for (int i = 0; i < n - 1; ++i) {
                    ans = Math.max(ans, arr[n - 1] - arr[i]);
                }

                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
