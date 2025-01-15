import java.io.*;
import java.util.StringTokenizer;

public class ques_5 {
//    https://codeforces.com/problemset/problem/1869/A
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
                // so now here we have the following things
                int len = in.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here we are done with the input

                // you idiot as we know that if we make the xor with same number it will give us the zero
                // so now take the even number of element and do the operation and make it same
                // then in the nex step we can make the same operation which will make it zero

                // so now here
                if(len % 2 == 0){
                    out.println(2);
                    out.println(1+" "+len);
                    out.println(1+" "+len);
                }else{
                    // so now here for the odd len first make the even len to the
                    out.println(4);
                    out.println(1+" "+ (len-1));
                    out.println(1+" "+(len-1));
                    out.println(len-1+" "+len);
                    out.println(len-1+" "+len);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
