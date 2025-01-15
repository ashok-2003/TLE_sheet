import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_31 {
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
            int n = in.nextInt();
            String str = in.next();
            // so now we can convert the string in to the number array and check if the array is sorted or not
            // but the length of the array will be very large

            char[] ss = str.toCharArray();
//            Arrays.sort(ss);
//            // so now here comparing
//            String sorted_str = new String(ss);
//            // so now compare the both string
//            if(str.equals(sorted_str)){
//                out.println("no");
//            }

            //why the fuck you want this like that just compare the adjacent elements only
            boolean sorted = true;
            for(int i = 1; i < n;  i++){ // should go the last index as checking the backward
                if(ss[i] < ss[i-1]){
                    sorted = false;
                    out.println("YES");
                    out.println(i + " " + (i+1)); // one based indexing
                    break;
                }
            }
            if(sorted){
                out.println("NO");
            }


            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
