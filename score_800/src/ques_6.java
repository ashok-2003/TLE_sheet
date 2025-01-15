import java.io.*;
import java.util.*;

public class ques_6 {
//    https://codeforces.com/problemset/problem/1890/A
    // dormey paint 3
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
                // so now here is the code so now as we have done the testcase here
                // so now here in this question it can be only true if it hav only one type of the element
                // or if it hav two types of distinct element so then only it can be true here
                int len = in.nextInt();
                Set<Integer> set = new HashSet<>();
                int[] arr = new int[len];
                for(int i = 0; i <len; i++){
                    arr[i] = in.nextInt();
                    // so nwo here we have to add it value in the set here
                    if(!set.contains(arr[i])){
                        set.add(arr[i]);
                    }
                }
                // so now here if the size become greater than two then we have to return no
                if(set.size() > 2){
                    out.println("no");
                }else{
                    // so now here we have to check that frequency should be not greater than the half element
                    if(set.size() == 2){
                        // so now here get the element and count it frequency here
                        List<Integer> ls = new ArrayList<>();
                        for(int i : set){
                            ls.add(i);
                        }
                        // so now here we have got the both nums here
                        int num1 = ls.get(0);
                        int num2 = ls.get(1);
                        // so now here
                        int count1 = 0;
                        int count2 = 0;
                        for(int i = 0; i < len; i++){
                            if(arr[i] == num1){
                                count1++;
                            } else if (arr[i] == num2) {
                                count2++;
                            }
                        }
                        // so now here
                        if(count1 > (len+1)/2 || count2 > (len+1)/2){
                            out.println("no");
                        }else{
                            out.println("yes");
                        }
                    }else{
                        out.println("yes");
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
