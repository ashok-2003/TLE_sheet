import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_19 {
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
                int n = in.nextInt();
                int[] arr = new int[n];
                int[] second_arr = new int[n];
                int[] ans = new int[n+1]; // as result array have one more element
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    second_arr[i] = arr[i];
                }
                // so now sort the secondary array
                Arrays.sort(second_arr);
                int count = 1;
                for(int i = n-1; i >= 0; i--){
                    int temp = second_arr[i]; // so now we have to find that value in the main array
                    int indx = -1;
                    for(int j = 0; j < n; j++){
                        if(arr[j] == temp){
                            indx = j;
                            arr[j] = -1; // changed the value
                            break;
                        }
                    }
                    // so now we have got the index
                    ans[indx+1] = count; // as the first index should be zero so ignoring that
                    if(count > 0){
                        count = -count;
                    }else{
                        count *= -1;
                        count+=1;
                    }
                }
                int sum = 0;
                int factor = 2; // Start with a factor of 2
                for (int i = n - 1; i > 0; i -= 2) { // Iterate from the last index
                    sum += (second_arr[i] + second_arr[i - 1]) * factor;
                    factor += 2; // Increment factor by 2 for the next pair
                }
                if (n % 2 != 0) { // If the array has an odd number of elements, process the smallest element
                    sum += second_arr[0] * factor;
                }

                out.println(sum);
                for(int i : ans){
                    out.print(i + " ");
                }
                out.println("");
                 */



                // so now trying to solve in nlogn
                int n = in.nextInt();
                int[][] arr = new int[n][2];
                for(int i = 0; i < n; i++){
                    arr[i][0] = in.nextInt();
                    arr[i][1] = i;
                }
                // so now sort the array on the index of first element

                Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

                // so now the array is sorted as  we know the index of each element so now
                int[] ans = new int[n+1];
                int count = 1;
                for(int i = n-1; i >= 0; i--) {
                    int indx = arr[i][1]; // so taking the index of the greater element
                    ans[indx + 1] = count;
                    if (count > 0) {
                        count = -count;
                    } else {
                        count *= -1;
                        count += 1;
                    }
                }
                long sum = 0;  // exceeded the value
                long factor = 2;
                for(int i = n-1; i > 0; i-=2){
                    sum += (arr[i][0] + arr[i-1][0])*factor;
                    factor+=2;
                }
                if(n % 2 != 0){
                    sum += arr[0][0]*factor;
                }
                out.println(sum);
                for(int i : ans){
                    out.print(i+ " ");
                }
                out.println("");

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
