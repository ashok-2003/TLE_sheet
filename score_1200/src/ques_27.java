import java.io.*;
import java.util.StringTokenizer;

public class ques_27 {
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

                String first = in.next();
                String second = in.next();

                // so append 0 in the both end at the last  so that we can compare the all of this
                first = first+"0";
                second = second+"0";

                out.println(solve(first , second));


            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    private static  String solve(String first , String second){
        // so now here we will compare the
        int n = first.length()-1; // as we have added the zero
        int count = 0;
        for (int i = 0; i < n; i++) {
            // so nwo checking for the count
            count += ( (first.charAt(i) == '1' ? 1 : 0) - (first.charAt(i) == '0' ? 1 : 0)); // making sure it is balanced
            // we check when we need to reverse here like making  1 to zero

            boolean sameCurrent = first.charAt(i) == second.charAt(i);
            boolean sameNext = first.charAt(i+1) == second.charAt(i+1);

            if(sameNext != sameCurrent && count != 0){
                // count != 0 means that string is not balanced here
                return "NO";
            }
        }
        return  "YES";
    }
}
