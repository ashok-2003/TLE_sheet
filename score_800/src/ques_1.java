import com.sun.tools.jconsole.JConsoleContext;

import java.util.*;
import java.io.*;
public class ques_1 {
    //halumoi boox question
//    https://codeforces.com/problemset/problem/1903/A/
    // same as the orderly queue question on the lettcode
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
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // so now here we  have to get the boxes count so if the k is greater than equal to 2 then we
                // can get the sorting here
                int n = in.nextInt();
                int k = in.nextInt();
                // so here we have to create the array if k is one
                int[] arr = new int[n];
                for(int i = 0; i < n; i++){
                    arr[i] = in.nextInt();
                }
                // so now here we have to print yes or not based on k here

                // so now here wer have to print yes in the two cases
                boolean issorted = true;
                if(k >= 2 || n == 1){
                    out.println("YES");
                }else{
                    // check if array is sorted of all element is equal
                    for(int i = 1; i < n; i++){
                        if(arr[i-1] > arr[i]){
                            issorted = false;
                            break;
                        }
                    }
                    if(!issorted){
                        out.println("NO");
                    }else{
                        out.println("YES");
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
