import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_11 {
//    https://codeforces.com/problemset/problem/1725/B
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
                int n = in.nextInt();
                int d = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                Arrays.sort(arr);
                // so now here we have to take the last value and make the team of it
                int ans = 0;
                int temp = n-1;
                while (n >= 0 && temp >= 0){
                    // so now team value should be strictly greater than that of
                    int curr = d / arr[temp];
                    curr++;
                    // so now here we have to add the value
                    if(n - curr >= 0){
                        n -= curr;
                        ans++;
                    }
                    temp--;
                }
                out.println(ans);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
