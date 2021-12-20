import java.util.Scanner;
import java.util.*;

public class E2 {
	
	public static long[] hasharr(char[] ch, int len, int p) {//哈希string
		long hash = 0L;
		long h=1;
		long[] hasharr = new long[ch.length-len+1];
		for(int i=0;i<len;i++) {
			hash *= p;
			hash += ch[i];
			if(i==len-1) break;
			h*=p;
		}
		hasharr[0] = hash;
		for(int i=1;i+len<ch.length+1;i++) {
			hasharr[i] = p*(hasharr[i-1]-ch[i-1]*h)+ch[i+len-1];
		}
		return hasharr;
	}
	
	public static boolean binarysearch(long[] arr, long num) {//二分查找
		int low = 0, high = arr.length - 1, mid = 0;
		boolean ans = false;
		if(!(num < arr[low] || num > arr[high] || low > high)) {
			while(low <= high) {
				mid = (low + high) / 2;
				if(arr[mid] > num) high = mid - 1;
				else if(arr[mid] < num) low = mid + 1;
				else{
					ans = true;
					break;
				}
			}
		}
		return ans;
	}
	
	public static boolean check(int len, char[] pattern, char[] text, int p) {
		long[] thash = hasharr(text, len, p);
		long[] phash = hasharr(pattern, len ,p);
		boolean ans = false;
		Arrays.sort(thash);
		for(int i=0;i<phash.length;i++) {
			if(binarysearch(thash, phash[i])) {
				ans = true;
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s1=input.next(), s2=input.next();
		int n = s1.length(), m = s2.length(), p = 131, ans = 0;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] pattern, text;
		if(n>m) {//选短的当pattern
			pattern = ch2;
			text = ch1;
		}else {
			pattern = ch1;
			text = ch2;
		}
		
		int left = 0, right = pattern.length, mid;//二分答案
		while(left<=right) {
			mid = (left+right)/2;
			if(check(mid, pattern, text, p)) {
				ans = mid;
				left = mid + 1;
			}else right = mid - 1;
		}
		System.out.println(ans);	
		input.close();
	}

}
