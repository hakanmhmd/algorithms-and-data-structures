import java.util.Arrays;
import java.util.Random;

/**
 * Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items,
 * where n is either a very large or unknown number. Typically n is large enough that the list doesn’t fit into
 * main memory. For example, a list of search queries in Google and Facebook.
 *
 How does this work?
 To prove that this solution works perfectly, we must prove that the probability that any item stream[i] where 0 <= i < n will be in final reservoir[] is k/n. Let us divide the proof in two cases as first k items are treated differently.

 Case 1: For last n-k stream items, i.e., for stream[i] where k <= i < n
 For every such stream item stream[i], we pick a random index from 0 to i and if the picked index is one of the first k indexes, we replace the element at picked index with stream[i]

 To simplify the proof, let us first consider the last item. The probability that the last item is in final reservoir = The probability that one of the first k indexes is picked for last item = k/n (the probability of picking one of the k items from a list of size n)

 Let us now consider the second last item. The probability that the second last item is in final reservoir[] = [Probability that one of the first k indexes is picked in iteration for stream[n-2]] X [Probability that the index picked in iteration for stream[n-1] is not same as index picked for stream[n-2] ] = [k/(n-1)]*[(n-1)/n] = k/n.

 Similarly, we can consider other items for all stream items from stream[n-1] to stream[k] and generalize the proof.

 Case 2: For first k stream items, i.e., for stream[i] where 0 <= i < k
 The first k items are initially copied to reservoir[] and may be removed later in iterations for stream[k] to stream[n].
 The probability that an item from stream[0..k-1] is in final array = Probability that the item is not picked when items stream[k], stream[k+1], …. stream[n-1] are considered = [k/(k+1)] x [(k+1)/(k+2)] x [(k+2)/(k+3)] x … x [(n-1)/n] = k/n
 */
public class ReservoirSampling {
    private static Random rand = new Random();
    public static void main(String[] args) {
        // something large - for simplicity assume
        int[] stream = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20};
        
        int[] sample = sampleStream(stream, 1);
        System.out.println(Arrays.toString(sample));
    }

    private static int[] sampleStream(int[] stream, int k) {
        int[] reservoir = new int[k];
        for(int i=0; i<k; i++) reservoir[i] = stream[i];

        for(int i=k; i<stream.length; i++){
            int j = rand.nextInt(i+1);
            if(j < k) reservoir[j] = stream[i];
        }

        return reservoir;
    }
}
