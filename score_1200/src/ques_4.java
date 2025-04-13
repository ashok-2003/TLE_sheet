import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_4 {
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
                int input_arr = (n * (n-1))/2;
                long[] arr = new long[input_arr];

                for (int i = 0; i < input_arr; i++) {
                    arr[i] = in.nextInt();
                }

                Arrays.sort(arr);
                // so now here we will count till we get the different index here
                int count = 1;
                long val = arr[0];
                for(int i = 0; i < input_arr; i++){

                    if(val == arr[i]){
                        count++;
                    }else{
                        // so now here we have to reset the count variable here
                        count = 1;
                        val = arr[i]; // and also reset the value here
                        i--;
                    }

                    if(count == n){
                        out.print(val + " ");
                        count = 1;
                        n--;
                    }
                }
                // so now for the outer loop here
                if(count != 1){
                    out.print(val + " ");
                    n--;
                }
                while (n > 0){
                    out.print(1000000000 + " ");  // giving the max value
                    n--;
                }
                out.println("");


            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
