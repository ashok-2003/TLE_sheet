import java.io.*;
import java.util.StringTokenizer;

public class ques_20 {
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
                // so now it dose not make sense to divide the array in more than 2 parts as if you divide in into the
                // three parts then it will be the multiple of previous gcd take a look at the example 4th
                // 1 2 1 1 1 3
                // either we can make 1 2 in one and rest in another or we can do 1 2 and 1 1 1 and 3 will give the same
                // result so now

                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();

                }
                // so now doing the prefix sum here
                long[] prefix = new long[n];
                prefix[0] = arr[0];
                for (int i = 1; i < n; i++) {
                    prefix[i] = prefix[i-1]+arr[i];
                }

                // so now at each of point we can calculate the gcd
                long sum = prefix[n-1]; // total sum
                // so now we have to divide it into the two parts so now

                long max_gcd = 1;  // bare minimum gcd of 2 number is 1
                for (int i = 0; i < n-1; i++) {
                    long divided_sum = sum - prefix[i];
                    max_gcd = Math.max(max_gcd , gcd(prefix[i] , divided_sum));
                    // so now at each point we are calculating the gcd of both divided parts
                }
                // for the final last element check

                max_gcd = Math.max(max_gcd , gcd(prefix[n-2] , arr[n-1])); // for the last element


                out.println(max_gcd);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    private static long gcd(long a , long b){
        while (b != 0){
            long remainder = a %b;
            a = b;
            b = remainder;
            // swapping insures that b is always smaller than a and gcd of a and b is same as gcd of a and a remainder b
        }
        return a;
    }
}
