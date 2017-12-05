package Arrays;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * Find the missing integer
 */
public class MissingElements {
    public static void main(String[] args) {
        int[] input = {8,2,9,7,6,4,5,1,3};
        System.out.println("Missing element is: " + findOneMissingElement(input));
        int[] input2 = {1, 3, 5, 6};
        System.out.print("Missing elements are: ");
        int[] missingElements = findTwoMissingElements(input2);
        for (int i = 0; i < missingElements.length; i++) {
            System.out.print(missingElements[i] + " ");
        }
    }

    private static int[] findTwoMissingElements(int[] input) {
        int n = input.length + 2;
        int allSum = n*(n+1)/2;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        int diff = allSum - sum;
        int avg = diff / 2;
        int smallHalfSum = 0, largeHalfSum = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] <= avg){
                smallHalfSum += input[i];
            } else {
                largeHalfSum += input[i];
            }
        }
        int sumToAvg = avg * (avg+1) / 2;
        int sumFromAvg = allSum - sumToAvg;

        int[] missing = new int[2];
        missing[0] = sumToAvg - smallHalfSum;
        missing[1] = sumFromAvg - largeHalfSum;
        return missing;
    }

    private static int findOneMissingElement(int[] input) {
        int n = input.length+1;
        int allSum = n * (n+1) / 2;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return allSum - sum;
    }
}
