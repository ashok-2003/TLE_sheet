import java.io.*;
import java.util.StringTokenizer;

public class ques_11 {
//    https://codeforces.com/problemset/problem/1866/A
    // abinioutious kid
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

                // so now here we have to just take the best minimum element here
                int min = Integer.MAX_VALUE;
                int len = in.nextInt();
                int[] arr = new int[len];
                for(int i = 0; i < len; i++){
                    // so now here
                    arr[i] = in.nextInt();
                    // so now here
                    if(arr[i] < 0){
                        arr[i] = -arr[i];
                    }
                    // so now here we have to take the thing if we get the min element then we have to update the
                    // value their here
                    if(arr[i] < min){
                        min = arr[i];
                    }
                }
                // so now here we have get the answer here
                out.println(min);

            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
