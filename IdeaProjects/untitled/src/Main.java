public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;
        for (int j = 0; j < n - 1; j++) {
            int iMin = j;
            for (int i = j + 1; i < n; i++) {
                if (arr[i] < arr[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                int temp = arr[j];
                arr[j] = arr[iMin];
                arr[iMin] = temp;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
