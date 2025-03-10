import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ques_1 {
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
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        try {
            Main.FastReader in=new Main.FastReader();
            Main.FastWriter out = new Main.FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // so now for this we have to use the dp technique here
                int n = in.nextInt();
                String str = in.next();


//                set = new HashSet<>();
//                allSet(str);
//                // adding the element itself also
//                set.add(str);
//                out.println(set.size());

                // so now the other approach is like
                Set<Character> charSet = new HashSet<>();
                long ans = 0;
                for(char ch : str.toCharArray()){
                    charSet.add(ch);
                    ans += charSet.size();
                }
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static void allSet(String str){
        if(str.isEmpty()){
            return;
        }
        if(str.length() == 1){
            set.add(str);
            return;
        }
        // so now here we have two option
        set.add(str.substring(1));
        allSet(str.substring(1));
        str = str.charAt(0) + str.substring(2);
        set.add(str);
        allSet(str);
    }

}
