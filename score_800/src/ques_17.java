import java.io.*;
import java.util.StringTokenizer;

public class ques_17 {
//    https://codeforces.com/problemset/problem/1845/A
    // forbidden integer
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
                // so now here we have to get the three input
                int target = in.nextInt();
                int number = in.nextInt();
                int notuse = in.nextInt();
                // so now here it have very basic solution here
                if(notuse != 1){
                    // so now here we can make it as this is not the 1 here so now
                    out.println("yes");
                    out.println(target);
                    for(int i = 0; i < target; i++){
                        out.print(1+" ");
                    }
                    out.println("");
                }else if (number == 1 || number == 2 && target % 2 == 1){
                    // so now here as the number is 1 hai so now not use bhi one hoga and number 2 hai and upar walle case
                    // me not caught so now here it will be that only so now
                    out.println("no");
                }else{
                    // so now here we can make that value using the 2 and 3 here so now here
                    // we can make it using the 2 and 3 here so now here
                    out.println("yes");
                    // so now here for the size we can use all the 2 and last one 3 if it is odd here
                    out.println(target/2);
                    // so now here
                    for(int i = 0; i < (target/2)-1; i++){
                        out.print(2+" ");
                    }
                    // so now here if the number was odd we have to print the 3 here
                    if(target % 2 == 1){
                        out.println(3);
                    }else{
                        out.println(2);
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
