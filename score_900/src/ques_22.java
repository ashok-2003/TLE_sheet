import java.io.*;
import java.util.StringTokenizer;

public class ques_22 {
//    https://codeforces.com/problemset/problem/1582/B
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
                // so now here we have to solve this with the dp or we can see any pattern here
                long len = in.nextLong();
                long count_0 = 0;
                long count_1 = 0;
                // so now here we have to count the number of 0 and 1 here
                int[] arr = new int[(int)len];
                for (int i = 0; i < len; i++) {
                    arr[i] = in.nextInt();
                    if(arr[i] == 0) count_0++;
                    if(arr[i] == 1) count_1++;
                }
                // so here we have
                long ans = (long)Math.pow(2 , count_0) * count_1;
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
