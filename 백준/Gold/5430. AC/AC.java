import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String p = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거

            String arr = sc.nextLine();
            arr = arr.replaceAll("[\\[\\]]", ""); // 대괄호 제거
            LinkedList<Integer> list = new LinkedList<>();

            if (!arr.isEmpty()) {
                String[] nums = arr.split(",");
                for (String num : nums) {
                    list.add(Integer.parseInt(num.trim()));
                }
            }

            boolean error = false;
            boolean reversed = false;

            for (char func :p.toCharArray()) {
                if (func=='R') {
                    reversed = !reversed;
                } else if (func=='D') {
                    if (list.size()==0) {
                        error = true;
                        break;
                    }
                    if (reversed) {
                        list.removeLast();
                    } else {
                        list.removeFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                if (reversed) {
                    StringBuilder sb = new StringBuilder("[");
                    while (!list.isEmpty()) {
                        sb.append(list.removeLast());
                        if (!list.isEmpty()) sb.append(",");
                    }
                    sb.append("]");
                    System.out.println(sb);
                } else {
                    System.out.println(list.toString().replace(" ", ""));
                }
            }

        }
    }
}