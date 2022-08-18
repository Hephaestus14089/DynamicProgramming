import java.util.*;

public class SumCombo {

    static boolean canSum(int target, int[] numbers) {
        if (target == 0) return true;

        // initialising array cell values
        boolean arr[] = new boolean[target + 1];
        arr[0] = true;
        for (int i = 1; i <= target; i++)
            arr[i] = false;

        int index = 0;

        for (int i = 0; i <= target; i++) {
            if (arr[i]) {
                for (int j = 0; j < numbers.length; j++) {
                    index = i + numbers[j];

                    if (index <= target)
                        arr[index] = true;

                    if (arr[target]) break;
                } // end of inner for loop

                if (arr[target]) break;
            }
        } // end of outer for loop

        return arr[target];
    } // end of canSum(int, int[])

    static int[] getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.print("Enter the no. of positive integers: ");
        int length = sc.nextInt();

        int arr[] = new int[length + 1];
        arr[0] = target;

        System.out.println("Enter the positive integers :-");
        for (int i = 1; i <= length; i++)
            arr[i] = sc.nextInt();

        sc.close();

        return arr;
    } // end of getUserInput()

    public static void main(String args[]) {
        int[] inputArray = getUserInput();

        int target = inputArray[0];
        int[] arr = new int[inputArray.length - 1];

        for (int i = 0; i < arr.length; i++)
            arr[i] = inputArray[i + 1];

        boolean isPossible = canSum(target, arr);

        if (isPossible)
            System.out.println("\nIs achievable");
        else
            System.out.println("\nIs NOT achievable");
    } // end of main()
} // end of SumCombo class
