import java.io.*;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1805/A
public class ques_24 {
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
                int len = in.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here if we get the answer of xor to zero then we should print it
                // otherwise if we have even length of array then we cannot get that answer see in the editiorial
                int xor = 0;
                for(int i : arr){
                    xor ^= i;
                }
                if(xor == 0){
                    out.println(0);
                }else{
                    if(len % 2 == 1){
                        // so length is odd so we can print the answer here
                        out.println(xor);
                    }else{
                        out.println(-1);
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
