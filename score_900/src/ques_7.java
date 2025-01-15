import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_7 {
//    https://codeforces.com/problemset/problem/1850/D
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
                // so now here we have to get
                int[] arr = new int[n];
                for(int i = 0; i < n; i++){
                    arr[i] = in.nextInt();
                }
                // so now here we have to get the max length which is greater than equal to that here
                Arrays.sort(arr);
                // so now here we have sort the array
                int count = 1;
                int ans = 1;
                for(int i = 1; i < n; i++){
                    if(arr[i] - arr[i-1] > k){
                        count = 1;
                    }else{
                        count++;
                    }
                    ans = Math.max(count , ans);
                }
                // so now here we have done that
                out.println(n - ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
