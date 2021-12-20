
public class QuickSort {
	
	static int partition(int n[], int left, int right) {
		int p = left;//new Random().nextInt(right-left+1)+left;
		int pivot = n[p];
        
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
	
    static void quicksortP(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksortP(n, left, dp - 1);
            quicksortP(n, dp + 1, right);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quicksortP(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
	}

}
