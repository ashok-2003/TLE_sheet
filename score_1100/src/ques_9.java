import java.io.*;
import java.util.StringTokenizer;

public class ques_9 {
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

                /*
                // here all should be long
                int n = in.nextInt();
                long square = in.nextLong();
                // so now during this loop we have to get their multiplication and their square sum
                long all_number_square_sum = 0;
                long all_number_multiplication = 1L;
                for (int i = 0; i < n; i++) {
                    long temp = in.nextLong();
                    all_number_multiplication *= temp;
                    all_number_square_sum += (temp * temp);
                }

                // so now here we have to calculate the all values for
                // a * w^2 + b* w + c

                long a = n * 4L;
                long b = 4 * all_number_multiplication;
                long c = square - all_number_square_sum;

                long d = findSquare(((b*b) + (4*a*c)));

                long val1 =  ((-b + d) / (2L * a));
                long val2 =  ((-b - d) / (2L * a));



                out.println(val1 >= 0 ? val1 : val2);
                // print the number 1 if the val1 is positive


                 */



                // so their is some sort of precision issue in the first solution i don't know from where that's
                // coming so now will stick to the brute force
                int n = in.nextInt();
                long c = in.nextLong();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                // as the max value of w is 10 ^ 9 max to max
                long start = 1;
                long end = (long)1e9;
                long ans = -1;

                while (start <= end) {
                    long mid = start + (end - start) / 2;
                    long sum_val = 0;
                    boolean exceeded = false;

                    for (int i = 0; i < n; i++) {
                        long temp = (arr[i] + 2 * mid);
                        if (sum_val > c - temp * temp) { // Prevent overflow
                            exceeded = true;
                            break;
                        }
                        sum_val += temp * temp;
                    }

                    // doing the logic here
                    if (exceeded || sum_val > c) {
                        end = mid - 1;
                    }
                    else if (sum_val == c){
                        ans = mid;
                        break;
                    }else {
                        start = mid + 1;
                    }
                }

                out.println(ans);

                // no need to return anything as the question says answer always present

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static  long findSquare(long n){
        // so now it will nearest if the value is not nearest
        long ans = 0;
        long start = 1;
        long end = n;
        while (end >= start){
            long mid = (start + end)/2;

            if((mid * mid) > n){
                end = mid-1;
            }

            else{
                ans = Math.max(mid , ans);
                start = mid+1;
            }
        }
        return  ans;
    }
}
