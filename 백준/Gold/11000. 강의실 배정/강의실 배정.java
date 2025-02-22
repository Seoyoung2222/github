import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수업 갯수
        int[][] lectureTime = new int[N][2];

        for (int i = 0; i < N; i++) {
            lectureTime[i][0] = sc.nextInt();
            lectureTime[i][1] = sc.nextInt();
        }
        Arrays.sort(lectureTime, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectureTime[0][1]); // 끝나는 시간 우선순위 큐 삽입

        for (int i = 1; i < N; i++) {
            if (lectureTime[i][0] >= pq.peek() && !pq.isEmpty()) {
                pq.poll();
            }
            pq.add(lectureTime[i][1]);
        }

        System.out.println(pq.size());
    }
}
