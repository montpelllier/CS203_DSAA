
public class SillySort {
	
	public static int[] InsertionSort(int[] arr) {
		int temp = 0;
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else break;
			}
		}
		return arr;
	}
	
	public static int[] SelectionSort(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {
			int k = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[k]) k = j;
			}
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		return arr;
	}
	
	public static int[] BubbleSort(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=1;j<arr.length;j++) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,25,25,2,52,6,46,536,537,45,3,62,542,6,72,53,72,537,25,72,53,7,45};
		arr = BubbleSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
