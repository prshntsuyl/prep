package practice.dynamic.greedy;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Nmeetings {

    //constrain:: start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
    public static void main(String[] args) {
        int N = 6;
        int[] S = new int[] {1, 3, 0, 5, 8, 5};
        int[] F = new int[] {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(S, F, N));
        // System.out.println(maxMeetings(S, F, N));

        int N1 = 8;
        int[] S1 = new int[] {75250, 50074, 43659, 8931, 11273,
                              27545, 50879, 77924
                             };
        int[] F1 = new int[] {112960, 114515, 81825, 93424, 54316,
                              35533, 73383, 160252
                             };

        // System.out.println(maxMeetings(S1, F1, N1));
    }

    public static class Node extends Comparable<Node>{

        public int startInd;
        public int endInd;

        Node(int startInd, int endInd) {
            this.startInd = startInd;
            this.endInd =  endInd;
        }

        public int compareTo(Node n) {
            return this.endInd - n.endInd;
        }

    } 

    public static int maxMeetings(int[] start, int end[], int n) {

        List<Node> nodeList = new ArryaList<Node>();
        for (int i=0; i<start.length; i++) {
           nodeList.add(new Node(start[i], end[j]));
        }

        Collections.sort(nodeList);

        for (Node node : nodeList) {
             System.out.println(node.startInd + "," + node.endInd);
         } 

        return 0; 
        // return maxMeetingsOnSorted(start, end, n);
    }

    public static int maxMeetingsOnSorted(int[] start, int end[], int n) {
        // add your code here(start);

        int count = 1;
        int k = 0;
        for (int i = 0; i < start.length; i++) {

			if(i + 1 == start.length) {
			    i++;
			    continue;
			}

            if (end[k] != start[i + 1] && end[k] < start[i + 1]) {
                count++;
                k = i;
            }
        }
        
        return count;
    }

    // N = 6
    // S[] = {1,3,0,5,8,5}
    // F[] = {2,4,6,7,9,9}
    // Answer is 4, we need the maximize the count of meeting per day
    static int maxMeetingsFailed(int start[], int end[], int n) {
        int max = 0;

        for (int i = 0; i < start.length; i++) {
            int currentCount = 0;
            int k = i;
            boolean skipped = false;

            for (int j = i; j < start.length; ) {
                currentCount++;
                if(j + 1 == start.length) {
                    j++;
                    continue;
                }

                if (end[k] != start[j + 1] && end[k] < start[j + 1]) {
                    j++;
                    k = j;
                    skipped = false;
                } else if (skipped) {
                    j++;
                } else {
                    j += 2;
                    skipped = true;
                }
            }
            if(currentCount >= max) {
                max = currentCount;
            }


        }

        return max;
    }
}