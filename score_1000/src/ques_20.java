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
            int[] xor = new int[300002];
            for(int i = 1; i <= 30000; i++){
                xor[i] = (xor[i-1] ^ i);
            }
            while(testCases-- > 0){
                int a = in.nextInt(); // mex value
                int b = in.nextInt(); // xor value
                // so the minimum length of the array should be mex value already as index will start
                int ans = xor[a-1];  // so that our mex can equal to x
                // so now if xor already equal to this
                if(ans == b){
                    out.println(a); // as zero based indexing
                }else{
                    if((b^ans) != a){
                        out.println(a+1); //
                    }else{
                        out.println(a+2);
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
