import java.io.*;
import java.util.StringTokenizer;

public class ques_15 {
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
                int k = in.nextInt();
                // so nwo here we have to make the length equal to b always
                String str = in.next();

                /*
                int min = Integer.MAX_VALUE;

                for(int i = 0; i <= n-k; i++){
                    // so now here we have to check the min
                    int val = countW(str.substring(i, i+k));
                    min = Math.min(min,val);
                }
                out.println(min);

gives tle in test case 4 due to extra loop
                 */
                // so now using the prefix sum here
                int[] prefix = new int[n];
                // so this will contain the prefix sum
                prefix[0] = (str.charAt(0) == 'W')? 1 : 0; // so if w at first character then it will print 1 other
                // wise zero
                for(int i = 1; i < n; i++){
                    prefix[i] = prefix[i-1] + ((str.charAt(i) == 'W') ? 1 : 0);
                }

                // so now checking for every substring
                int min = Integer.MAX_VALUE;
                for(int i = 0; i <= n-k; i++){
                    int val = 0;
                    if(i == 0){
                        val = prefix[i+k-1] - 0;
                    }else{
                        val = prefix[i+k-1] - prefix[i-1];
                    }
                    min = Math.min(min , val);
                }
                out.println(min);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int countW(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'W'){
                count++;
            }
        }
        return count;
    }
}
