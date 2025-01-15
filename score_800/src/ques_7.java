import java.io.*;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1881/A
// dont' try to count
// so note here loop dose not go more than 6 as the length is 25 max so as we have seen the max 6 len we can reach in it
public class ques_7 {
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
                // so now here is the code so now as we done the tescase here
                // so now here
                int alen = in.nextInt();
                int targetlen = in.nextInt();
                StringBuilder s = new StringBuilder(in.next());
                String target = in.next();
                int loop = Math.abs(alen - targetlen)/2 + 1;
                // so nwo here we have to run the loop here
                boolean is = false; // so now it will track whether we have find the answer in it or not
                // so now here we have to check whether it have different digit rather than the same of not
                String ss = s.toString();
                for(char c : target.toCharArray()){
                    // so now here if s don't contains any of the digit then return true for the -1 case here
                    String temp = ""+c;
                    if (ss.contains(temp) == false){
                        is = true;
                        break;
                    }
                }
                // so now here we have to check for it
                if(is == true){
                    out.println(-1);
                }else {
                    for (int i = 0; i <= loop; i++) {
                        // so nwo here
                        if (s.toString().contains(target)) {
                            out.println(i);
                            is = true;
                            break;
                        } else {
                            // so now here we have to just make the string add the previous
                            s.append(s);
                        }
                    }
                    if (is == false) {
                        out.println(-1);
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}


class ques_7_2 {
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
                // so now here
                int alen = in.nextInt();
                int targetlen = in.nextInt();
                StringBuilder s = new StringBuilder(in.next());
                String target = in.next();
                boolean is = false;
                for(int i = 0; i <= 6; i++){
                    if (s.toString().contains(target)) {
                        out.println(i);
                        is = true;
                        break;
                    } else {
                        // so now here we have to just make the string add the previous
                        s.append(s);
                    }
                }
                if(is == false){
                    out.println(-1);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
