import java.io.*;
import java.util.StringTokenizer;

public class ques_26 {
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
            final long MOD = 1000000007;
            while(testCases-- > 0){
//                https://www.youtube.com/watch?v=0jeCN9l-mOY&t=6s
                long n  = in.nextLong();
                int k  = in.nextInt();

                long ans = ModPower(n , k , MOD);
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  long ModPower(long base , int power , long mod){
        long result = 1;
        base = base % mod; // initial base dose not overflow
        while (power > 0){
            if((power & 1) == 1){
                // so when power is odd we will do
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            power = power >> 1;
        }
        return  result;
    }
}
