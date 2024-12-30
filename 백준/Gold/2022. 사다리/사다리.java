import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);


        double left = 0, right = Math.min(x, y);

        while (right > left) {
            double width = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
            double res = (h1 * h2) / (h1 + h2);
  
            if (res >= c) left = width + 0.001;
            else right = width - 0.001;
        }
        System.out.println(String.format("%.3f", left));
    }
}