package practice.treeq.binary;


class BinarySearchInRotated {

	public static void main(String[] args) {
  //       int N = 9;
		// int[] arr = new int[]{5,6,7,8,9,10,1,2,3};

  //       System.out.println(binarysearch(arr, N, 3));

        int N = 3;
		int[] arr = new int[]{3,1,2};

        System.out.println(Search(arr, 1));
	}

    static int Search(int[] arr, int target) {
        // code here
        int midPoint = arr.length / 2;

        return binarySearchWithMid(arr, midPoint, target);
    }

    static int binarySearchWithMid(int[] arr, int midPoint, int k) {
    	int startPoint = arr[0];
        if(arr[midPoint] == k) {
            return midPoint;
        }

        if((k > arr[midPoint] && k < startPoint) || (k < arr[midPoint] && k < startPoint)){
            int newMidPoint = midPoint + (arr.length - midPoint) / 2 ;
            return binarySearchWithMid(arr, newMidPoint, k);
        } 
        
        int newMidPoint = (midPoint) / 2;
        return binarySearchWithMid(arr, newMidPoint, k);
    }
}