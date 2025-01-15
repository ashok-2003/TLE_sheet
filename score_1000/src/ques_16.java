import java.io.*;
import java.util.StringTokenizer;

public class ques_16 {
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
                int r = in.nextInt();
                int b = in.nextInt();

                // Calculate the size of each partition
                int div = r / (b + 1);
                int rem = r % (b + 1);

                // StringBuilder for building the result
                StringBuilder str = new StringBuilder();

                // Construct the string
                for (int i = 0; i < b; i++) {
                    str.append("R".repeat(div)); // Add main "R" partition
                    if (rem > 0) {              // Add an extra "R" for the remainder if available
                        // pigeonhole principal  adding the reaming value of string
                        str.append("R");
                        rem--;
                    }
                    str.append("B");            // Add "B" between partitions
                }

                // Add the final partition of "R"
                str.append("R".repeat(div));
                if (rem > 0) {
                    str.append("R".repeat(rem)); // Append any remaining "R"
                }

                // Output the result
                out.println(str.toString());
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
