import java.io.*;
import java.util.StringTokenizer;

public class ques_15_1 {
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
                long sum = 0;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    sum += arr[i];
                }

                if(sum < k){
                    out.println(-1);
                    continue;
                }

                // so now here we can do one thing we calculate the prefix sum and for each part we will check
                // as p[r] - p[l-1] = k this should be our sum so will try to maximize the length and p[r]
                // will be the first index as it include 0 and 1 both

                long[] prefix = new long[n+1];
                prefix[0] = 0;
                for (int i = 1; i <= n; i++) {
                    prefix[i] = prefix[i-1] + arr[i-1];
                }

                // so now here we have to search

                int len = -1;

                for (int i = 1; i <= n; i++) {
                    long target = prefix[i-1] + k;
                    int right = lowerBinary(prefix, target); // search in indices i to n
                    if(right != -1) {
                        int diff = right - (i-1);  // because length = r - (l-1)
                        len = Math.max(len, diff);
                    }
                }


                out.println(n - len);

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  int lowerBinary(long[] arr , long target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] <= target){
                if(arr[mid] == target){
                    ans = mid;
                }
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return  ans;
    }
}
