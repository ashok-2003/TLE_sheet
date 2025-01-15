import java.io.*;
import java.util.StringTokenizer;

public class ques_9 {
//    https://codeforces.com/problemset/problem/1877/A
    // goals of victory
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
                // so now here as the logic is the main thing here so now
                // as  overall the goal if all get added should be zero that's how this will be the fair game
                // so now the last will be somehow that make the total to the zero here
                int len = in.nextInt();
                int sum = 0;
                int[] arr = new int[len];
                // so now here we have to run the loop with
                for (int i = 0; i < len-1; i++) {
                    arr[i] = in.nextInt();
                    sum += arr[i];
                }
                // so now here we have to return the answer here
                out.println(-sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
