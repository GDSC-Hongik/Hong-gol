import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];  // 크기를 N으로 조정
        tmp = new int[N];  // 크기를 N으로 조정

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge_sort(int s, int e) {
        if (e <= s)
            return;

        int m = (s + e) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m + 1;

        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] <= tmp[idx2]) {
                arr[k++] = tmp[idx1++];
            } else {
                arr[k++] = tmp[idx2++];
            }
        }

        while (idx1 <= m) {
            arr[k++] = tmp[idx1++];
        }
        while (idx2 <= e) {
            arr[k++] = tmp[idx2++];
        }
    }
}