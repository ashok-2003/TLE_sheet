import java.io.*;
import java.util.StringTokenizer;

public class ques_19 {
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
                int negativeCount = 0;
                int positiveCount = 0;
                for(int i = 0; i < n; i++){
                    int temp = in.nextInt();
                    if(temp == 1){
                        positiveCount++;
                    }else{
                        negativeCount++;
                    }
                }
                // so now here
                if(positiveCount >= negativeCount){
                    // so now it means positive count is greater so only multiplication tension
                    if(negativeCount % 2 == 0){
                        out.println(0);
                    }else{
                        out.println(1);
                    }
                }else{
                    // so now here we have the first task to make it positive
                    int diff = negativeCount - positiveCount;
                    if(diff % 2 != 0){
                        diff = diff/2+1;
                    }else{
                        diff = diff/2;
                    }
                    int ans = 0;
                    ans += diff;
                    negativeCount -= diff;
                    // so now here we will check for the
                    if(negativeCount % 2 != 0){
                        ans++;
                    }
                    out.println(ans);
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
