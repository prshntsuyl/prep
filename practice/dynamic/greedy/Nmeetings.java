package practice.dynamic.greedy;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Nmeetings {

    //constrain:: start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
    public static void main(String[] args) {
        int N = 6;
        int[] S = new int[] {1, 3, 5, 0, 5, 8};
        int[] F = new int[] {2, 4, 9, 6, 7, 9};

        System.out.println(maxMeetings(S, F, N));

        int N1 = 30;
        int[] S1 = new int[] {48, 43, 61, 54, 99, 84, 3, 3, 59, 30, 45, 72, 24, 87, 21, 48, 54, 88, 8, 67, 41, 64, 87, 54, 5, 62, 87, 33, 74, 92};
        int[] F1 = new int[] {150, 67, 137, 131, 139, 115, 49, 6, 117, 126, 59, 109, 27, 96, 73, 60, 99, 108, 50, 145, 68, 104, 102, 82, 7, 126, 118, 93, 148, 150};

        System.out.println(maxMeetings(S1, F1, N1));
    }

    //because sorting is needed
    public static class Node implements Comparable<Node> {

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
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < start.length; i++) {
            nodeList.add(new Node(start[i], end[i]));
        }

        Collections.sort(nodeList);

        int i = 0;
        for (Node node : nodeList) {
            start[i] = node.startInd;
            end[i] = node.endInd;
            i++;

        }

        return maxMeetingsOnSorted(start, end, n);
    }

    public static int maxMeetingsOnSorted(int[] start, int end[], int n) {
        int count = 1;
        int k = 0;

        for (int i = 1; i < start.length; i++) {
           if (end[k] < start[i]) {
                count++;
                //last selected item at i
                k = i;
            }
        }

        return count;
    }

    //First attempt
    //Input
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