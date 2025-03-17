import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<int[]> applicants = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // 서류 순위
                int y = sc.nextInt(); // 면접 순위
                applicants.add(new int[]{x, y});
            }

            applicants.sort(Comparator.comparing(a->a[0]));

            int result = 0;
            int minInterview = Integer.MAX_VALUE;

            for (int[] applicant : applicants) {
                int interview = applicant[1];

                if (interview < minInterview) {
                    result++;
                    minInterview = interview;
                }
            }
            System.out.println(result);
        }
    }
}