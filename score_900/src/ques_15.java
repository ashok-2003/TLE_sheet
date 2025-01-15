import java.io.*;
import java.util.StringTokenizer;

public class ques_15 {
//    https://codeforces.com/problemset/problem/1675/B
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
                // so now here we have to check from the backward we will divide by 2 until it become smaller
                // so if this became to zero we will break and print -1 their
                int n = in.nextInt();
                int[] arr = new int[n];
                // so now here
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                solve(n , arr);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static void solve(int n , int[] arr){
        // so now here
        int ans = 0;
        for(int i = n-2; i >= 0; i--){
            while(arr[i] >= arr[i+1] && arr[i] > 0){ // remember that after that case will excute inside of this
                // for arr[i] == 1 this will excute here also
                ans++;
                arr[i] /= 2;
            }
            // so nwo here we have to check
            if(arr[i] == arr[i+1]){
                System.out.println(-1);
                return;
            }
        }
        // so now here we have to print ans
        System.out.println(ans);
    }
}
