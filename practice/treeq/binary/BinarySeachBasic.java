package practice.treeq.binary;


class BinarySeachBasic {

    public static void main(String[] args) {
        // int N = 5;
        // int[] arr = new int[] {1, 2, 3, 4, 5};

        // System.out.println(binarysearch(arr, N, 1));

        int N = 5;
		int[] arr = new int[]{11,22,33,44,55,66};
        System.out.println(binarysearch(arr, N, 66));
    }

    static int binarysearch(int[] arr, int n, int k) {
        // code here
        int midPoint = n / 2;

        return binarySearchWithMid(arr, midPoint, k);
    }

    static int binarySearchWithMid(int[] arr, int midPoint, int k) {
    	if (k < arr[0]|| k > arr[arr.length-1]) {
    		return -1;
    	}

        if(arr[midPoint] == k) {
            return midPoint;
        }

        if(k > arr[midPoint]) {
            int newMidPoint = midPoint + (arr.length - midPoint) / 2 ;
            return binarySearchWithMid(arr, newMidPoint, k);
        } 
        
        int newMidPoint = (midPoint) / 2;
        return binarySearchWithMid(arr, newMidPoint, k);
    }
}