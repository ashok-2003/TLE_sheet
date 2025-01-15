import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_4 {
//    https://codeforces.com/problemset/problem/1859/B
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
                // so now here we have to consider the second value here from each of the testcase here
                long sum_second_min = 0;
                long smallest = Integer.MAX_VALUE;
                long second_smallest = Integer.MAX_VALUE;
                // as we can see that min value of
                int test = in.nextInt();
                while (test-- > 0){
                    long m = in.nextInt();
                    long[] arr = new long[(int) m];
                    for (int i = 0; i < m; i++) {
                        arr[i] = in.nextLong();
                    }
                    // so now here sort the array
                    Arrays.sort(arr);
                    sum_second_min += arr[1];
                    smallest = Math.min(smallest , arr[0]);
                    second_smallest = Math.min(second_smallest , arr[1]);
                }

                // so now here we have got all value
                out.println(smallest + sum_second_min - second_smallest);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
