import java.io.*;
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
                int n = in.nextInt();
                char c = in.next().charAt(0);
                String s = in.next();
                char[] str = s.toCharArray();

                // so now we need at max 2 operation to solve this
                // here 2 and 3 would not work like for index 6 divisible by both so here not of them will change
                // the value to c then

                // checking if all same
                boolean isAllSame = true;
                for(int i = 0; i < n; i++){
                    if(str[i] != c){
                        isAllSame  = false;
                        break;
                    }
                }
                if(isAllSame){
                    out.println(0);  // as all of them is already same
                    continue;
                }

                int val = -1;
                // so now searching for the index where the all mutilple is already c so we can update it
                for(int i = 2; i <= n; i++){ // due to one indexed
                    boolean valid = true;
                    for(int x = i; x <= n; x+=i){
                        if(str[x-1] != c){
                            valid = false;
                            break;
                        }
                    }
                    if(valid){
                        val = i;
                        break;
                    }
                }
                if(val != -1){
                    out.println(1);
                    out.println(val);
                }else{
                    // we can use two operation
                    out.println(2);
                    out.println(n + " " + (n-1));
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
