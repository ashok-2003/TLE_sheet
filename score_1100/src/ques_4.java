import java.io.*;
import java.util.StringTokenizer;

public class ques_4
    {
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
                int[] arr = new int[n];
                int maxSum = Integer.MIN_VALUE;
                for(int i = 0; i < n; i++){
                    arr[i] = in.nextInt();
                    maxSum = Math.max(arr[i] , maxSum);
                }
                // so now here will compare the current sum with the max sum
                int currSum = arr[0];
                for(int i = 1; i < n; i++){
                    if(Math.abs(arr[i]) % 2 == Math.abs(arr[i-1]) % 2){
                        // so now here
                        maxSum = Math.max(maxSum , currSum);
                        currSum = arr[i];
                    }else{
                        maxSum = Math.max(maxSum , currSum);
                        currSum = Math.max(currSum + arr[i] , arr[i]);
                        maxSum = Math.max(currSum , maxSum);
                    }
                }

                out.println(maxSum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

}
