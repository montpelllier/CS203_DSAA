
public class MergeSort {

	public static int[] sortR(int[] arr, int left, int right) {//recursion
		if(left == right) return new int[] {arr[left]};
		int mid = (left+right)/2;
		int[] leftarr = sortR(arr, left, mid);
		int[] rightarr = sortR(arr, mid+1, right);
		int[] SortedArr = new int[leftarr.length + rightarr.length];//separate arrays
		
		int i=0, j=0, k=0;
		while(k < leftarr.length+rightarr.length) {
			if(i < leftarr.length && (j == rightarr.length || leftarr[i] <= rightarr[j]))
				SortedArr[k++] = leftarr[i++];
			else SortedArr[k++] = rightarr[j++];
		}//merge arrays
		return SortedArr;
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int SortedArr[] = new int[right-left+1];
		int l=left, r=mid+1, a=0, b=0; 
		while(l <= mid && r <= right) {
			if(arr[l] > arr[r]) {
			//	times += mid-l+1;
				SortedArr[a++] = arr[r++];
			}else SortedArr[a++] = arr[l++];
		}
		while(l <= mid) {
			SortedArr[a++] = arr[l++];
		}
		while(r <= right) {
			SortedArr[a++] = arr[r++];
		}
		for(int i=left;i<=right;i++) {
			arr[i] = SortedArr[b++];
		}
	}
	
	public static void sortI(int[] arr, int left, int right) {//iteration
		if(left < right) {
			int mid = (left + right)/2;
			sortI(arr, left, mid);
			sortI(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {3,2,5,23,42,25,5,4,62,35,87,7,56,54,24,2,52,352,32,90};
		sortI(test, 0, test.length-1);
		for(int i : test) {
			System.out.print(i+" ");
		}
	}

}
