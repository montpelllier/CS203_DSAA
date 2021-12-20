import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int arr[] = {1,3,5,7,11,13,17,19,25,29,35,37,43,47,53,55,63,69,79,83,93,99,107,109,117,123,133,137,147,153,161,163,173,181,195,201,217,227,241,245,259,269,285,291,305,313,323,325,335,343,357,363,379,389,403,407,421,431,447,453,467,475,485,487,499,509,527,535,557,571,591,597,619,635,661,671,695,709,727,731,749,763,787,797,823,839,861,867,887,901,923,931,949,959,971,973,985,995,1013,
		};
		int t = input.nextInt();
		while (t-->0) {
			int n = input.nextInt();
			if(n == 1) {
				System.out.print(1);
			}else 
				System.out.println(arr[n/2-1]);
		}
		
		input.close();
	}

}