import java.io.*;
import java.util.StringTokenizer;

public class ques_6 {
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
                int q = in.nextInt();
                int[] a = new int[n];


                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                int[] x = new int[q];
                for (int i = 0; i < q; i++) {
                    x[i] = in.nextInt();
                }
                // both array is initialized here


                // so now here is a thing if the number is can be divided by 2^3(8) so it the number must
                // have at least 3 trailing zeros(zeros from the last places continuous) so after that operation
                // it will not able to again divided by 2^3 or any greater number as the 3rd bit is now one which make
                // the trailing zero to 2 now  it can only divide the smaller number only


                int min_div = Integer.MAX_VALUE;
                for(int i = 0; i < q; i++){

                    if(x[i] >= min_div){ // so any number who have same or greater than x[i] should be skipped
                        continue;
                    }
                    min_div = x[i]; // setting the min value of div to the number as it have gone through the  operation
                    int val = 1 << x[i]; // right shift similar to the power
                    int add = 1 << (x[i]-1);

                    for(int j = 0; j < n; j++){
                        if(a[j] % val == 0){
                            a[j] += add; // added the required number
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    out.print(a[i] + " ");
                }
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
