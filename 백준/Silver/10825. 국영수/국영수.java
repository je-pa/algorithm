import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0 ; i< N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(
                new Info(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                )
            );
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll().name);
        }
        
    }
    
    static class Info implements Comparable<Info>{
        String name;
        int korea;
        int english;
        int math;
        public Info(String name, int korea, int english, int math){
            this.name = name;
            this.math = math;
            this.korea = korea;
            this.english = english;
        }
        public int compareTo(Info o){
            if(this.korea != o.korea) return Integer.compare(o.korea, this.korea);
            if(this.english != o.english) return Integer.compare(this.english, o.english);
            if(this.math != o.math) return Integer.compare(o.math, this.math);            
            return this.name.compareTo(o.name);
        }
    }
}