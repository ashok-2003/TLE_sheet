import java.io.*;
import java.util.StringTokenizer;

public class ques_23 {
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
                // as the 4th divisor will the number itself and if the difference is 2 or greater than 2
                // then the number can not be the even as it will become divisible by 1 and 2 both
                int n = in.nextInt();
                int first = 1;
                int second = findNextPrime(1+n);
                int third = findNextPrime(second+n);
                // so now for the other case
                out.println(first* second * third);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int findNextPrime(int n){
        int digit = n;
        while (true){
            if(prime(digit)){
                return digit;
            }
            digit++;
        }
    }
    static  boolean prime(int n){
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
