import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ques_12 {
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
            final int MOD = 1_000_000_007;
            int testCases=in.nextInt();
            while(testCases-- > 0){
                /*
                so the main thing here is we have to get the all possible combination
                so for that we have to deal with the greater element first that in how many way we can get that
                so sorting the arr a in ascending and b in descending order so now we will get the element b
                greater element so now will see in arr a in how many way we can get that
                for each time the number of possibility  will reduce from the one as one element is being used
                and that will be the greater element so that's how that logic used
                 */
                int n = in.nextInt();
                int[] arr_a = new int[n];
                Integer[] arr_b = new Integer[n];  // stored as integer because reverse sorting not work on int
                for (int i = 0; i < n; i++) {
                    arr_a[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    arr_b[i] = in.nextInt();
                }


                Arrays.sort(arr_a);
                Arrays.sort(arr_b , Collections.reverseOrder()); // descending order



                long ans = 1;
                for (int i = 0; i < n; i++) {

                    int target = arr_b[i];

                    int index = binary(arr_a , target);


                    ans = ( ans *  (Math.max((n - index - i), 0))  )%MOD;  // as -i because each time when one digit get

                    if(ans == 0 ){
                        break;
                    }
                }

                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    private static int binary(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = arr.length; // Default: if no element is >= target

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {   // as we need the element that is greater than ai > bi
                ans = mid;  // Store valid index
                end = mid - 1; // Search on the left side
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
