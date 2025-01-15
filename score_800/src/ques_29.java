import java.io.*;
import java.util.StringTokenizer;

public class ques_29 {
//    https://codeforces.com/problemset/problem/1777/A
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
                // so now here we have to change the array in the format
                int len = in.nextInt();
                int[] arr = new int[len];
                for(int i  = 0; i < len; i++){
                    arr[i] = in.nextInt();
                    if(arr[i] % 2 == 0){
                        arr[i] = 0;
                    }else {
                        arr[i] = 1;
                    }
                }
                // so now here we have fill the array with the zero and 1
                // 0 for even number and 1 for odd number here
                int ans = 0;
                for(int i = 1; i < len; i++){
                    if(arr[i-1] == arr[i]){
                        ans++;
                    }
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
