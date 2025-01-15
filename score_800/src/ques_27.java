import java.io.*;
import java.util.StringTokenizer;

public class ques_27 {
//    https://codeforces.com/problemset/problem/1788/A
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
                // so for this we will the suffix sum and prefix multiply to that so now here is the solution
                int len = in.nextInt();
                int[] arr = new int[len];
                int count2 = 0;
                for(int i = 0; i < len; i++){
                    arr[i] = in.nextInt();
                    if(arr[i] == 2){
                        count2++;
                    }
                }
                if(count2 == 0){
                    out.println(1);
                    continue;
                }
                // so now if we got the count of 2 to be odd then we can't
                if(count2 % 2 == 1){
                    out.println(-1);
                    continue;
                }
                // so now here we have to count the 2 in the other case here
                // and it should be constitive so for that we doing this
                count2 = count2 / 2;
                for(int i = 0; i < len; i++){
                    if(arr[i] == 2){
                        count2--;
                    }
                    if(count2 == 0){
                        out.println(i+1);
                        break;
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
