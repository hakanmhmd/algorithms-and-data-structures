package BitManipulation;

/**
 * ou are given an array A containing 2*N+2 positive numbers, out of which N numbers are repeated exactly twice
 * and the other two numbers occur exactly once and are distinct. You need to find the other two numbers
 * and print them in ascending order.
 */
public class Find2Numbers {
    public static void main(String[] args) {
        int[] arr = {1,2, 6, 2, 1, 4};
        findNums(arr);
    }

    private static void findNums(int[] arr) {
        int xor = 0;
        for(int i: arr) xor ^= i;
        int num1 = 0, num2 = 0;
        int difBit = xor & ~(xor - 1);
        for(int i = 0; i < arr.length; i++){
            if((difBit & arr[i]) == 0){
                num1 ^= arr[i];
            }else{
                num2 ^= arr[i];
            }
        }
        if(num1 > num2){
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        System.out.println(num1 + " " + num2);
    }
}
