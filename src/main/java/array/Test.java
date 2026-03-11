package array;

//8688452236 K@truN#21995 https://leetcode.com/u/saiganesh_reddy/
//8309443946
@FunctionalInterface
interface MyTest{
	void test();
}

public class Test {
	
	public static void main(String[] args) {
		int[] a = {1, 1, 2, 1, 0, 5 };
		System.out.println(util(a));
	}

	public static int util(int[] a) {
		int minJumps = 0;
		int maxReach = 0;
		int maxReachEnd = 0;
		for (int i = 0; i < a.length; i++) {
			if (maxReach < i)
				return -1;
			maxReach = Math.max(maxReach, i + a[i]);
			if (i == maxReachEnd) {
				minJumps++;
				maxReachEnd = maxReach;
			}
		}
		return minJumps;
	}
}
