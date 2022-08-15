import java.util.*;

class ConstructCombo {

    static boolean isPrefix(String subset, String superset) {
        int subLength = subset.length();

        if (subLength > superset.length()) return false;

        for (int i = 0; i < subLength; i++)
            if (subset.charAt(i) != superset.charAt(i))
                return false;

        return true;
    }

    static String getSuffix(String prefix, String str) {
        int prefLength = prefix.length();

        if (prefLength >= str.length()) return "";
        return str.substring(prefLength);
    }

    static boolean canConstruct(String target, String[] subsetArr, HashMap<String, Boolean> memo) {
        if (target == "") return true;
        if (memo.get(target) != null) return memo.get(target);

        String suffix = "";
        boolean val = false;

        for (int i = 0; i < subsetArr.length; i++) {
            if (isPrefix(subsetArr[i], target)) {
                suffix = getSuffix(subsetArr[i], target);

                val = canConstruct(suffix, subsetArr, memo);
                memo.put(target, val);

                if (val) return true;
            }
        } // end of for loop

        return false;
    }

    // wrapper function for canConstruct
    static boolean canConstruct(String target, String[] subsetArr) {
        HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
        return canConstruct(target, subsetArr, memo);
    }

    public static void main(String args[]) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Enter target string: ");
        String target = sc1.nextLine();

        System.out.print("Enter number of sub-strings: ");
        int n = sc1.nextInt();
        String subsetArr[] = new String[n];

        System.out.println("Enter sub-strings :-");
        for (int i = 0; i < subsetArr.length; i++)
            subsetArr[i] = sc2.nextLine();

        sc1.close();
        sc2.close();

        if (canConstruct(target, subsetArr))
            System.out.println("Construction Possible.");
        else
            System.out.println("Construction Not Possible.");
    } // end of main(String[])
} // end of class ConstructCombo
