import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // O의 갯수
        int m = sc.nextInt(); // s의 길이
        sc.nextLine();
        String strings = sc.nextLine();

        char[] chars = strings.toCharArray();

        int result = 0;
        for (int i = 0; i < m-(2*n); i++) {
            if (chars[i] == 'I') {
                boolean flag = true;
                for (int j = 1; j <= n*2; j++) {
                    if (j%2==1 && chars[i+j]=='O') {
                        continue;
                    } else if (j%2==0 && chars[i+j]=='I') {
                        continue;
                    } else {
                        flag = false;
                    }
                }
                if (flag) result++;
            }
        }
        System.out.println(result);
    }
}
