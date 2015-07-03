package fm;

public class MainTest {
	static int count = 0;// 总换的瓶数

	public static void main(String[] args) {
		// bottles(20, 2);
		System.out.println(bottleCount(20, 2));
	}

	/**
	 * 如果有m瓶 n个瓶子换一瓶 请写出该算法:
	 * 
	 */
	// do while
	public static void bottles(int m, int n) {
		int x = 0;// 商
		int y = 0;// 余数
		do {
			x = m / n;
			y = m % n;
			m = x + y;
			count += x;
		} while (m > 1);
		System.out.println(count);
	}

	// 递归
	public static int bottleCount(int m, int n) {
		int x = 0;// 商
		int y = 0;// 余数
		x = m / n;
		y = m % n;
		m = x + y;
		if (m <= 1) {
			count += m;
			return count;
		} else {
			count += x;
			return bottleCount(m, n);
		}
	}
}
