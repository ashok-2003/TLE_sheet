import java.io.*;
import java.util.Arrays;
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
                int n = in.nextInt();
                long x = in.nextLong();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }
                Arrays.sort(arr);
                // so now we have to also calculate the prefix sum
                long[] prefix = new long[n];
                prefix[0] = arr[0];
                for (int i = 1; i < n; i++) {
                    prefix[i] = prefix[i-1] + arr[i];
                }

                long count = 0;
                int currIndex = 0;
                long countedValue = 0;
                // so now here for the first time we have to check for the part which is first time less than
                for(int i = n-1; i >= 0; i--){
                    if(prefix[i] <= x){
                        count += (i+1); // that many have been counted
                        countedValue++;
                        currIndex = i;
                        break;
                    }
                }

                // so now here we have to use for the currIndex value
                while (currIndex >= 0){
                    long diff = x - (prefix[currIndex] + ( (currIndex+1) * countedValue));
                    if(diff >= 0){
                        long extraDays = diff / (currIndex+1) + 1;
                        count += extraDays * (currIndex+1);
                        countedValue += extraDays;
                    }
                    currIndex--;
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
