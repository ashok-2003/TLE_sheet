import java.io.*;
import java.util.StringTokenizer;

public class ques_17 {
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
                // just check the number of bits the mex value should go up to the 2^number of bits
                // the decrease by one till 0 then 2 ^ k then 2 ^ k+1 for the less mex value
                int n = in.nextInt();
                // so now here counting the bit of it
                int number_of_bit = bit(n-1);
                // so now here print all the values here
                int val = (int)Math.pow(2 , number_of_bit)-1; // -1 because as we have to start from the  2^k -1 val
                // so for 2 bits it will become 2 ^ 1
                while (val >= 0){
                    out.print(val + " ");
                    val--;
                }
                val = (int)Math.pow(2 , number_of_bit); // so now for the further values
                // se the test case 4  2 ^ 3 is 8 but we have to print the 9 also
                while (val < n){
                    out.print(val + " ");
                    val++;
                }
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static int bit(int n ){
        int count = 0;
        while (n>0){
            n = n>>1;
            count++;
        }
        return count-1; // as the power of 2 will start form the bit for 1 also so for that
        // subtracting 1 so if the number is 8 then it should gives the k = 3 but if we see that bits are 4 here
    }
}
