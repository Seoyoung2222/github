/*
* 예산 배정하기
* 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
* 2. 아닌 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산 요청에는 모두 상한액을 배정. 이하의 예산 요청에는 요청한 금액을 그대로 배정
* */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static long M;

    public static long binarySearch(long left, long right) {
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = 0;
            for (int budget : arr) {
                sum += Math.min(budget, mid);
            }

            if (sum <= M) {
                result = mid;
                left = mid + 1;
            } else { // 예산 초과 시 상환액 줄이기
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지방의 수
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        M = sc.nextInt(); // 예산

        if (Arrays.stream(arr).sum()<=M) {
            System.out.println(Arrays.stream(arr).max().getAsInt());
        } else {
            System.out.println(binarySearch(0, Arrays.stream(arr).max().getAsInt()));
        }
    }
}
