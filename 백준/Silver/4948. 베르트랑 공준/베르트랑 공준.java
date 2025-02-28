import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            boolean[] isPrime = new boolean[2*n+1];

            // 초기값 설정
            for (int i = 2; i <= 2*n; i++) {
                isPrime[i] = true;
            }

            // 에라토스테네스의 체
            for (int i = 2; i*i <= 2*n; i++) { // 제곱근까지만 검사
                if (isPrime[i]) {
                    for (int j = i*i; j <= 2*n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            int result = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime[i]) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}
