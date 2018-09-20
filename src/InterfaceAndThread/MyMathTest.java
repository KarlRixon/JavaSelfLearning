package InterfaceAndThread;

import org.junit.Test;

import junit.framework.TestCase;

public class MyMathTest {

	@Test
	public void testDiv() {
//		fail("Not yet implemented");
		try {
			TestCase.assertEquals(MyMath.div(10, 2), 5);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
