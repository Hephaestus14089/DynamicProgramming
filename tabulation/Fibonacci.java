public class Fibonacci {

    static int getNthElement(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int arr[] = new int[--n];

        for (int i = 1; i < n; i++)
            arr[i] = 0;

        arr[0] = 1;

        for (int i = 0; i < n - 2; i++) { // skipping first element beacuse it is 0
            arr[i + 1] += arr[i];
            arr[i + 2] += arr[i];
        }

        arr[n - 1] += arr[n - 2];

        return arr[arr.length - 1];
    }

    public static void main(String args[]) {
        try {
            System.out.println(getNthElement(Integer.parseInt(args[0])));
        }
        catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }
}
