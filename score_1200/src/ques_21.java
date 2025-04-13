import java.io.*;
import java.util.StringTokenizer;

public class ques_21 {
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
                int[] arr = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    arr[i] = in.nextInt();
                }

//                https://chatgpt.com/c/67f8108d-529c-8003-8de3-01ebd89119c3
                // see this for the better explanation here \
                int total = 0;
                for(int i = 1; i <= n; i++){
                    int x = arr[i];
                    // so now as by deriving the equation here
                    int maxCandidate = (2 * n)/x;
                    for(int k = 1; k <= maxCandidate; k++){   // this loop will run very short
                        // so now here we have to get the index for that k
                        int j = (x * k) - i;  // as ai*aj = i+j
                        // so now we are assuming the value of k here is aj as we have finalized the ai
                        if(j > i && j <= n){
                            if(arr[j] == k){  // as our assumed value should match
                                total++;
                            }
                        }
                    }
                }
                out.println(total);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
