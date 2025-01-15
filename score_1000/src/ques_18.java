import java.io.*;
import java.util.StringTokenizer;

public class ques_18 {
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
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while(testCases-- > 0){
                int w = in.nextInt();
                int h = in.nextInt();

                // Read points on horizontal sides (y = 0 and y = h)
                int n = in.nextInt();
                int x_axis_min = Integer.MAX_VALUE;
                int x_axis_max = Integer.MIN_VALUE;
                for(int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    x_axis_min = Math.min(x_axis_min, x);
                    x_axis_max = Math.max(x_axis_max, x);
                }

                int n2 = in.nextInt();
                int x_axis_w_min = Integer.MAX_VALUE;
                int x_axis_w_max = Integer.MIN_VALUE;
                for(int i = 0; i < n2; i++) {
                    int x = in.nextInt();
                    x_axis_w_min = Math.min(x_axis_w_min, x);
                    x_axis_w_max = Math.max(x_axis_w_max, x);
                }

                // Read points on vertical sides (x = 0 and x = w)
                int n3 = in.nextInt();
                int y_axis_min = Integer.MAX_VALUE;
                int y_axis_max = Integer.MIN_VALUE;
                for(int i = 0; i < n3; i++) {
                    int y = in.nextInt();
                    y_axis_min = Math.min(y_axis_min, y);
                    y_axis_max = Math.max(y_axis_max, y);
                }

                int n4 = in.nextInt();
                int y_axis_h_min = Integer.MAX_VALUE;
                int y_axis_h_max = Integer.MIN_VALUE;
                for(int i = 0; i < n4; i++) {
                    int y = in.nextInt();
                    y_axis_h_min = Math.min(y_axis_h_min, y);
                    y_axis_h_max = Math.max(y_axis_h_max, y);
                }

                // Calculate the maximum possible areas
                long max_x = Math.max((long)(y_axis_max - y_axis_min) * w, (long)(y_axis_h_max - y_axis_h_min) * w);
                long max_y = Math.max((long)(x_axis_max - x_axis_min) * h, (long)(x_axis_w_max - x_axis_w_min) * h);
                long max_area = Math.max(max_x, max_y);

                out.println(max_area);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

