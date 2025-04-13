import java.io.*;
import java.util.StringTokenizer;

public class ques_18 {
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
            while(testCases-- > 0) {
                int n = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }

                // so observe one thing here if the array is not sorted we can make all element equal to n-2 and n-1
                // difference so that all will be same so no need to change anything
                // but if the last element is negative then we can't perform any sorting if array is not sorted

                if(arr[n-2] > arr[n-1]){
                    out.println(-1);
                    continue;
                }

                if(arr[n-1] < 0){
                    // so check if the array is sorted or not
                    boolean isSorted = true;
                    for (int i = 1; i < n; i++) {
                        if(arr[i] < arr[i-1]){
                            isSorted = false;
                            break;
                        }
                    }
                    if(!isSorted){
                        out.println(-1);
                    }else{
                        out.println(0);
                    }

                    continue;
                }

                // so now for the remaining case
                out.println(n-2);
                for(int i = 1; i <= n-2; i++){
                    out.println(i + " " + (n-1) + " " + (n));
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
