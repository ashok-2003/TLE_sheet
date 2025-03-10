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
                int x = in.nextInt();
                int[] arr1 = new int[n];
                int[] arr2 = new int[n];
                int[] arr3 = new int[n];

                // so now here
                for(int i = 0; i < n; i++){
                    arr1[i] = in.nextInt();
                }
                for(int i = 0; i < n; i++){
                    arr2[i] = in.nextInt();
                }for(int i = 0; i < n; i++){
                    arr3[i] = in.nextInt();
                }
                // so now here
                if(x == 0){
                    out.println("Yes");
                    continue;
                }
                // for the other case we have to use the recursion most probally for it

                boolean ans = isVal(arr1 , arr2 , arr3 , 0 , 0 , 0 , x , 0);

                out.println(ans == true ? "yes" : "no");


            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  boolean isVal(int[]arr1 , int[] arr2 , int[] arr3 , int i , int j , int k , int x , int val){
        if(val == x){
            return true;
        }
        if(i >=  arr1.length || j >= arr2.length || k >= arr3.length){
            return false;
        }

        // so now here we have three option either take the stack value of the first or second or third
        boolean val1 = isVal(arr1 , arr2 , arr3 , i+1 , j , k , x , (val | arr1[i]));
        boolean val2 = isVal(arr1 , arr2 , arr3 , i , j+1 , k , x , (val | arr2[j]));
        boolean val3 = isVal(arr1 , arr2 , arr3 , i , j , k+1 , x , (val | arr3[k]));

        return val1 || val2 || val3;
    }
}
