import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i=1 ; i<=a ; i++){
            for(int k=0 ; k<i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
