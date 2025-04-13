import java.io.*;
import java.util.StringTokenizer;

public class ques_16_1 {
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
            long currSum = 0;
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                currSum += arr[i];
            }
            // so now here for each of q we have to take the value here
            int globalTimeStamp = 0;
            long globalValue = -1;
            int[] timeStamp = new int[n];  // maintain the current time stamp for each value



            while (q-- > 0){
               int type = in.nextInt();
               if(type == 1){
                   int index = in.nextInt()-1;
                   long val = in.nextLong();

                   long currVal;
                   if(timeStamp[index] < globalTimeStamp){
                       currVal = globalValue;
                   }else{
                       currVal = arr[index];
                   }

                   // so now here we have to add the value in the curr sum and
                   // update the index also
                   currSum += (val - currVal);

                   arr[index] = val;
                   timeStamp[index] = globalTimeStamp; // update to the latest so if occur then the  < global will return
                   // false

                   out.println(currSum);

               }else{
                   // for the type two
                   long val = in.nextLong();

                   globalTimeStamp++;
                   globalValue = val;

                   currSum = val * n;

                   out.println(currSum);
               }
            }


            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
