import java.io.*;
import java.util.*;

public class ques_23 {
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
                String str = in.next();

                boolean found = false;
                for(char ch = 'a'; ch <= 'z'; ch++){
                    String candidate = ""+ch;
                    if(!str.contains(candidate)){
                        out.println(candidate);
                        found = true;
                        break;
                    }
                }
                if(found){
                    continue;
                }

                // so now checking for the size two here
                for(char x = 'a'; x <= 'z'; x++){
                    for(char y = 'a'; y <= 'z'; y++){
                        String candidate = ""+x+y;
                        if(!str.contains(candidate)){
                            out.println(candidate);
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        break;
                    }
                }
                if(found){
                    continue;
                }

                // so checking for the case three also here
                for(char x = 'a'; x <= 'z'; x++) {
                    for (char y = 'a'; y <= 'z'; y++) {
                        for(char z = 'a'; z <= 'z'; z++){
                            String candidate = ""+x+y+z;
                            if(!str.contains(candidate)){
                                out.println(candidate);
                                found = true;
                                break;
                            }
                        }
                        if(found){
                            break;
                        }
                    }
                    if(found){
                        break;
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
