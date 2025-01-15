import java.io.*;
import java.util.StringTokenizer;

public class ques_1 {
//    https://codeforces.com/problemset/problem/1913/B
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
                // so now here taking the string input
                String str = in.next();
                int len = str.length();
                // so now here
                int count1 = 0;
                int count0 = 0;
                for(char ch : str.toCharArray()){
                    if(ch == '0'){
                        count0++;
                    }else{
                        count1++;
                    }
                }
                if(count0 == len || count1 == len){ // base case we have to delete all here
                    out.println(len);
                    continue;
                }
                // so now here the min step is we have to make the both equal 0 and 1 amount here
                if(count0 == count1){
                    out.println(0);
                    continue;
                }
                if(len == 1){
                    out.println(1);
                    continue;
                }
                // so now here
                int i = 0;
                while (i < len){
                   if(str.charAt(i) == '0'){
                       if(count1 == 0){
                           break;
                       }
                       count1--;
                   }else if(str.charAt(i) == '1'){
                       if(count0 == 0){
                           break;
                       }
                       count0--;
                   }
                   i++;
                }
                // so now here after that we have to print the remaining part here
                out.println((count0 + count1));
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
