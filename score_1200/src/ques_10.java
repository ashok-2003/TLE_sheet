import java.io.*;
import java.util.StringTokenizer;

public class ques_10 {
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
                int k = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }

                // so now as we know we can only climb till the index which is smaller so if we maintained the max
                // type of thing till every index then we can easily do the binary search

                long[] prefixMax = new long[n];
                long[] prefixSum = new long[n];
                prefixSum[0] = arr[0];
                prefixMax[0] = arr[0];
                for(int i = 1; i < n; i++){
                    prefixSum[i] = prefixSum[i-1]+arr[i];
                    prefixMax[i] = Math.max(prefixMax[i-1] , arr[i]);
                }
                // so now here for each of the answer we will iterate like the binary search here

                for(int i = 0; i < k; i++){
                    long ques = in.nextLong();

                    int index = maxBinary(prefixMax , ques);
                    long ans = (index >= 0 ? prefixSum[index] : 0);
                    out.print(ans + " ");
                }
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    private static int maxBinary(long[] arr , long target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while (start <= end){

            int mid = start + (end-start)/2;

            if(arr[mid] > target){
                end = mid-1;
            }else{
                ans = Math.max(ans , mid);
                start = mid+1;
            }
        }
        return  ans;
    }
}
