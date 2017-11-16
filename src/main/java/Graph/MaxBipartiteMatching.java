package Graph;

import java.util.Arrays;

/**
 * There are M job applicants and N jobs. Each applicant has a subset of jobs that he/she is interested in.
 * Each job opening can only accept one applicant and a job applicant can be appointed for only one job.
 * Find an assignment of jobs to applicants in such that as many applicants as possible get jobs.
 */
public class MaxBipartiteMatching {
    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a bpGraph shown in the above example
        boolean bpGraph[][] = new boolean[][]{
                {false, true, true, false, false, false},
                {true, false, false, true, false, false},
                {false, false, false, false, false, false},
                {false, false, true, true, false, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, true}
        };
        MaxBipartiteMatching m = new MaxBipartiteMatching();
        System.out.println( "Maximum number of applicants that can"+
                " get job is "+m.maxBPM(bpGraph));
    }

    private int maxBPM(boolean[][] bpGraph) {
        int M = bpGraph.length; //applicants
        int N = bpGraph[0].length; //jobs

        // -1 if no applicant is matched to a job
        int[] matches = new int[N];
        Arrays.fill(matches, -1);

        int count = 0;//number of jobs assigned

        for (int i = 0; i < M; i++) {
            boolean[] seen = new boolean[N];

            //find if applicant i can get a job
            if(dfs(bpGraph, seen, i, matches)){
                count++;
            }
        }
        return count;
    }

    private boolean dfs(boolean[][] bpGraph, boolean[] seen, int x, int[] matches) {
        for(int i=0; i<bpGraph[0].length; i++){
            // if applicant is interested and havent seen it
            if(bpGraph[x][i] && !seen[i]) {
                seen[i] = true;

                if(matches[i] < 0 || dfs(bpGraph, seen, matches[i], matches)){
                    matches[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
