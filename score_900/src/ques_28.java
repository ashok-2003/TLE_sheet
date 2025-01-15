import java.io.*;
import java.util.StringTokenizer;

public class ques_28 {
//    https://codeforces.com/problemset/problem/1440/B
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
                int[] arr = new int[n*k];
                for (int i = 0; i <n*k; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here first get the median of the array
                int median = ((n+1)/2);
                // so now here see the left value
                int skip = (n - median)+1;
//                out.println(skip);
                // so now add that value from the back
                long sum = 0; //integer overflow
                for(int i = (n*k)-skip; i >= 0; i-=skip){
//                    out.print(arr[i] + " ");
                    sum += arr[i];
                    k--;
                    if(k == 0){
                        break;
                    }
                }
                out.println(sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
