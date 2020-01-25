public class CacheTest{

	public static void main(String[] args){
		SimpleCache<Integer,String> testCache = new SimpleCache<Integer,String>(10);
		testCache.add(27, "Test");
		testCache.add(28, "Test");
		testCache.add(29, "Test");
		testCache.add(21, "Test");
		testCache.add(22, "Test");
		testCache.add(23, "Test");
		testCache.add(24, "Test");
		testCache.add(25, "Test");
		testCache.add(26, "Test");
		testCache.add(272, "Test");
		testCache.add(271, "Test");
		testCache.add(27, "Test2");
		testCache.add(21, "Test");
		Object[] test = testCache.keys();
		for(int i = 0; i < test.length; i++)
			System.out.println(test[i]);
		int[] test2 = new int[test.length];
		for(int i = 0; i < test.length; i++)
			test2[i] = (int) test[i];
		System.out.println(test2[3]);
		System.out.println(testCache.find(20));
		System.out.println(test[0].equals("Test"));
		testCache.clear();
		test = testCache.values();
		for(int i = 0; i < test.length; i++)
			System.out.println(test[i]);
	}






}