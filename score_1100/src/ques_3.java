import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
// this test case answer should be 0 3 3 3
//1
//        4
//        3 8 4 5



// so this method not working because of the following reason
/*
for i = 4 the array would be
3 8 5 // as we have to remove the current element
so now it can reach till all of the elements becuase when it get the value of that element it added it sum
but we are precaululating the value of sum so tha's why this method not working here
 */

public class ques_3 {
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
                long[] arr = new long[n];
                long[] arr_copy = new long[n];
                Map<Long , Long> map = new HashMap<>(); // so this contains the value of sum till that point of
                for(int i = 0; i < n; i++){
                    arr[i] = in.nextLong(); // input as long
                    arr_copy[i] = arr[i];
                }
                // so now sort the copy array
                Arrays.sort(arr_copy); // so now it is sorted
                // so now writing the sum of value till that of index here
                long sum = 0;
                for(int i = 0; i < n; i++){
                    sum += arr_copy[i];
                    map.put(arr_copy[i] , sum);
                }
                // so now for each of element we have to print the answer
                long[] final_answer = new long[n];
                for(int i = 0; i < n; i++){
                    long sum_till_val = map.get(arr[i]);
//                    out.println(sum_till_val + " " + i);

                    // so now searching the index of that val sum in the array
                    int index = Binarysrch(arr_copy , sum_till_val);
                    // so now what if same number are over the like the repated number
                    while (index+1< n && arr_copy[index+1] <= sum_till_val){
                        index++;
                    }
                    // again calulating for the new index
                    long prev_val = 0;


                    // tried for again computing the value still get the wrong answer only
                    
                    do {
                        prev_val = sum_till_val;
                        sum_till_val = map.get(arr_copy[index]);
                    }while (prev_val != sum_till_val);


                    index = Binarysrch(arr_copy , sum_till_val);
                    final_answer[i] = index;
                }
                for(long i : final_answer){
                    out.print(i+ " ");
                }
                out.println("");

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int Binarysrch(long[] arr, long target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
