import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), k=input.nextInt();
		int[][] QR;
		String result;
		LinkedList<int[][]> cache = new LinkedList<int[][]>();
		Iterator<int[][]> iterator; 
		
		while(n-->0) {
			result = "miss";
			iterator = cache.iterator();
			QR = new int[16][16];
			for(int i=0;i<16;i++) {
				for(int j=0;j<16;j++) {
					QR[i][j] = input.nextInt();
				}
			}
			while(iterator.hasNext()){
				if(compare(iterator.next(), QR)) {
					iterator.remove();
					result = "hit";
					break;
				}
			}
			cache.add(QR);
			if(cache.size()>k) cache.removeFirst();
			System.out.println(result);
		}
		
		input.close();
	}
	
	public static boolean compare (int[][] a, int[][] b) {
		boolean result = true;
		label: for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(a[i][j] != b[i][j]) {
					result = false;
					break label;
				}
			}
		}
		
		return result;
	}

}
