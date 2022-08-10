import java.util.*;

class Container_bool {
    boolean val;
    boolean isFilled;

    Container_bool() {
        val = false;
        isFilled = false;
    } // end of default constructor

    void fill(boolean value) {
        val = value;
        isFilled = true;
    } // end of fill(int)
} // end of class Container

public class SumCombo {

    static boolean canSum(int target, int[] arr) { // wrapper function for canSum
        Container_bool[][] memoMatrix = new Container_bool[target + 1][target + 1];

        for (int i = 0; i <= target; i++)
            for (int j = 0; j <= target; j++)
                memoMatrix[i][j] = new Container_bool();

        return canSum(target, arr, memoMatrix);
    } // end of canSum(int, int[][])

    static boolean canSum(int target, int[] arr, Container_bool[][] memoMatrix) {
        if (target == 0) return true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                if (!memoMatrix[target][arr[i]].isFilled)
                    memoMatrix[target][arr[i]].fill(canSum(target - arr[i], arr, memoMatrix));
                if (memoMatrix[target][arr[i]].val)
                    return true;
            }
        } // end of for loop

        return false;
    } // end of canSum(int, int[], int[][])

    // int[] howSum(int target, int[] arr) {}

    // int[] bestSum(int target, int[] arr) {}

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

        System.out.println("\n" + isPossible);
    } // end of main()
} // end of class SumCombo
