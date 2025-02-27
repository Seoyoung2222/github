import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // IOI 패턴 갯수
        int m = sc.nextInt(); // 문자열 길이
        sc.nextLine();
        String s = sc.nextLine();

        int result = 0;
        int count = 0;

        for (int i = 0; i < m-1; i++) {
            if (s.charAt(i) == 'I' && i+2<m && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I') {
                count++;
                if (count >= n) {
                    result++;
                }
                i++; // 'OI'를 스킵하고 다음 카운트 시작
            } else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}