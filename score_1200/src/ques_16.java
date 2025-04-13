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
            int n = in.nextInt();
            int q = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // so now here for the each of case we have to print the value here
            for (int i = 0; i < q; i++) {
                int type = in.nextInt();
                int[] subArr = new int[2];
                if(type == 1){
                    subArr[0] = in.nextInt(); // index on which index have to replace
                    subArr[1] = in.nextInt(); // and the value with that we have to do
                }else{
                    subArr[0] = in.nextInt(); // replace all element with this value here
                }

                // so now here
                long sum = 0;
                if(type == 1){
                    for (int j = 0; j < n; j++) {
                        if(j == subArr[0]-1){
                            arr[j] = subArr[1];
                        }
                        sum += arr[j];
                    }
                }else{
                    // for type 2 replace all elements
                    for (int j = 0; j < n; j++) {
                        arr[j] = subArr[0];
                        sum += arr[j];
                    }
                }

                out.println(sum);
            }

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
