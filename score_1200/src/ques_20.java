import java.io.*;
import java.util.StringTokenizer;

public class ques_20 {
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
                String s = in.next();
                char[] str = s.toCharArray();

                // so now we know their are 26 alphabets so we can check for each of them now
                int ans = Integer.MAX_VALUE;
                char curr = 'a';
                for(int i = 0; i < 26; i++){
                    char temp = (char) (curr+i);
                    int start = 0;
                    int end = n-1;
                    int count = 0;
                    boolean isValid = true;
                    while (start < end){
                        if(str[start] == str[end]){
                            start++;
                            end--;
                        }else if(str[start] == temp){
                            start++;
                            count++;
                        }else if(str[end] == temp){
                            end--;
                            count++;
                        }else{
                            // so if any of them dose not execute then return
                            isValid = false;
                            break;
                        }
                    }
                    if(isValid){
                        ans = Math.min(ans , count);
                    }
                }

                out.println(ans != Integer.MAX_VALUE ? ans : -1);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
