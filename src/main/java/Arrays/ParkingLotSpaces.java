package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * In a linear parking lot, all spots are occupied except one. Each car has a unique id. Only available move
 * is to move a car to the empty place. The desired positions of the cars is given too. The task is to move all the
 * cars in their desired positions in the min number of moves.
 */
public class ParkingLotSpaces {
    public static void main(String[] args) {
        int[] cars =    {1,3,4,2,0,6,5,7};
        int[] desired = {3,1,0,4,2,5,6,7};

        System.out.println(minMoves(cars, desired));
    }
    static int moveCount = 0;
    private static int minMoves(int[] cars, int[] desired) {
        Map<Integer, Integer> carIdToIndex = new HashMap<>();
        for(int i=0; i<cars.length; i++){
            carIdToIndex.put(cars[i], i);
        }
        int zeroIndex = carIdToIndex.get(0);

        for(int i=0; i<cars.length; i++){
            while(desired[zeroIndex] != 0){
                int swapIndex = carIdToIndex.get(desired[zeroIndex]);
                swap(zeroIndex, swapIndex, carIdToIndex, cars);
                zeroIndex = swapIndex;
            }

            if(cars[i] != desired[i]){
                swap(zeroIndex, i, carIdToIndex, cars);
                zeroIndex = i;
            }
        }


        return moveCount;

    }

    private static void swap(int zeroIndex, int swapIndex, Map<Integer, Integer> carIdToIndex, int[] cars) {
        carIdToIndex.put(0, swapIndex);
        carIdToIndex.put(cars[swapIndex], zeroIndex);

        cars[zeroIndex] = cars[swapIndex];
        cars[swapIndex] = 0;

        moveCount++;
    }
}
