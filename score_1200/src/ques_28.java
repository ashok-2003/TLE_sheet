import java.io.*;
import java.util.StringTokenizer;

public class ques_28 {
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
                int n = in.nextInt();
                int m = in.nextInt();
                // so now instead of storing the array we will store the remainder frequency of it
                int[] freq = new int[m+1];
                for(int i = 0; i < n; i++){
                    long val = in.nextLong();
                    int rem = (int) (val % m);
                    freq[rem]++;
                }
                long count = 0;
                if(freq[0] != 0){
                    freq[0] = 0; // updated to zero
                    count++; // so the first array have been counted here
                }
                // so now as frequency is stored so now here we have to calculate the now possible array firs of all
                for(int i = 1; i <= (m+1)/2; i++){  // do not need to check the full array

                    int firstFreq = freq[i];
                    int lastFreq = freq[m-i];

                    // so now here we have to take the math.min of both here
                    int min_val = Math.min(firstFreq , lastFreq);

                    if(min_val != 0){
                        // so this can be constructed into one array so now for that
                        count++; // array size increase
                        freq[i] -= min_val;
                        freq[m-i] -= min_val;
                        // so nwo here if both have equal values then no worries otherwise we have to subtract
                        // one more as we can accommodate one more in middle
                        if(freq[i] > 0 ){
                            freq[i]--;
                        }else if (freq[m-i] > 0){
                            freq[m-i]--;
                        }
                    }
                }

                // so nwo here we have to make the remaining array to be counted as single
                for(int i = 1; i <= m; i++){
                    if(freq[i] > 0){
                        count += freq[i];
                    }
                }

                out.println(count);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
