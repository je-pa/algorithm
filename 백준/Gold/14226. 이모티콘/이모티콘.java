import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Icon> queue = new LinkedList<>();
        queue.add(new Icon(1,0,0));
        boolean[][] visited = new boolean[1001][1001];
        while (!queue.isEmpty()){
            Icon cur = queue.remove();
            if(cur.screen == N){
                System.out.println(cur.count);
                return;
            }
            if(cur.screen+ cur.clip< visited.length && !visited[cur.clip][cur.screen+ cur.clip]){
                queue.add(new Icon(cur.screen + cur.clip, cur.count+1, cur.clip));
                visited[cur.clip][cur.screen + cur.clip] = true;
            }
            queue.add(new Icon(cur.screen, cur.count+1, cur.screen));
            if(cur.screen>=1 && !visited[cur.clip][cur.screen-1]){
                queue.add(new Icon(cur.screen-1, cur.count+1, cur.clip));
                visited[cur.clip][cur.screen-1] = true;
            }
        }
    }
}
class Icon{
    int screen;
    int count;
    int clip;

    Icon(int screen, int count, int clip){
        this.screen = screen;
        this.count = count;
        this.clip = clip;
    }
}
