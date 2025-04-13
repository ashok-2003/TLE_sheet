import java.io.*;
import java.util.StringTokenizer;

public class ques_3 {
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
                long n = in.nextLong();
                long x = in.nextLong();
                long y = in.nextLong();


                /*

                long x_sum = 0;
                long y_sum = 0;
                long increment = n;
                for(long i = x; i <= n; i+=x){
                    if(i % y == 0){
                        continue;
                    }
                    x_sum += increment;
                    increment--;
                }
                increment = 1;
                for(long i = y; i <= n; i+=y){
                    if(i % x == 0){
                        continue;
                    }
                    y_sum += increment;
                    increment++;
                }

                out.println(x_sum - y_sum);

                */

                // so now here we can make it as ap and calculate in 0(1)
                // as we have to take the red index which is only divisible by x and blue index which is only divisible
                // by y and skip the index which is common i.e lcm which is purple color we have to skip that

                long lcm = lcm(x , y);
                // so now taking the red index here
                long red_index = (n/x) - (n/lcm);
                long blue_index = (n/y) - (n/lcm);

                // so now using ap to calculate the values

                long x_sum = ((n + (n-red_index +1)) * red_index)/2;
                long y_sum = ((1 + blue_index) * blue_index)/2;

                out.println(x_sum - y_sum);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    private static long gcd (long a , long b){
        while (b != 0){
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        return  a;
    }
    private  static  long lcm (long a , long b){
//        return (a * b) / gcd(a , b); // but this multiplication might lead to long overflow so for that
        return (a / gcd(a , b)) * b; // as gcd is divisible by both number
    }
}
