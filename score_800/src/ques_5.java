import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_5 {
//    https://codeforces.com/problemset/problem/1896/A
    // jagged swap
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
                // new code here


                /*
                // best code

                // so now here we have to check two thing first is permutation if the number is repeated or not
                // and second thing is we have to check if we get the number 1 at the number one spot
                int sum = 0;
                int n = in.nextInt();
                int target = (n*(n+1))/2;
                int[] arr = new int[n];
                for(int i = 0; i < n; i++){
                    arr[i] = in.nextInt();
                    sum += arr[i];
                }
                if(arr[0] == 1 && sum == target){
                    // sum == target for checking whether we have present array is permutation or not
                    out.println("YES");
                }
                else{
                    out.println("NO");
                }

                */



                // so now here the total cases we have to see that here
                //1 . it contains the only digit from the 1 to n here only like if the length is 3 and it contains then it is false
                //2. it dose not contain any of the duplicate elements
                // so now after all of this is the first index of the array is smallest then it can become the sorted
                // so now running all of the here
                int len = in.nextInt();
                int[] arr = new int[len];
                boolean ans = true;
                for(int i = 0; i < len; i++){
                    arr[i] = in.nextInt();
                    // so now checking here if the index is greater than the length the make it false
                    if(arr[i] > len){
                        ans = false;
                    }
                }
                // so now here if the it excedded the element then we have to make it no
                if(ans == false){
                    out.println("no");
                }else{
                    // so now here it have all the element which it greater than equal to this in the order here
                    // so now here if we don't have the smallest element i.e 1 at the first index then it is also
                    // not true then so now here
                    if(arr[0] != 1){
                        out.println("no");
                    }else{
                        // so now here otherwise it means it have 1 st element to the 1 at the first index here
                        // so now before reutrning to the true we have to check if the it have duplicate
                        // or not so for that here we have to sort the array and check inside of it
                        ans = true;
                        Arrays.sort(arr);
                        for(int i = 1; i < len; i++){
                            // so now here
                            if(arr[i] == arr[i-1]){
                                ans = false;
                            }
                        }
                        // so now here
                        if(ans == false){
                            out.println("no");
                        }else{
                            out.println("yes");
                        }
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
