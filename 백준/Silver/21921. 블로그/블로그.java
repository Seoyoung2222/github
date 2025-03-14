import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 블로그 운영일수
        int X = sc.nextInt(); // 확인 기간
        int[] psum = new int[N+1];
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            int visitor = sc.nextInt();
            sum += visitor;
            psum[i] = sum;
        }

        int max = 0;

        for (int i = N; i >= X; i--) {
            max = Math.max(max,psum[i]-psum[i-X]);
        }

        if (max==0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            int count = 0;
            for (int i = N; i >= X; i--) {
                if (psum[i]-psum[i-X]==max) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
