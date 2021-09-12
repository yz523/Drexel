import junit.framework.*;
import org.junit.*;
import static org.junit.Assert.*; 

public class gIntTest extends TestCase{
	
	private static gInt r1, m1 ,a1, a2, m1, m2, n;

	//c'tor
	public gIntTest(String name){
		super(name);
	}

	@BeforeClass
	//run before every test
	protected void setUp() {
		r1 = new gInt(1,2);
		m1 = new gInt(2,3);
		a1 = new gInt(1,2);
		a2 = new gInt(2,3);
		neg1 = new gInt(-1,-1);
		m1 = new gInt(6,5;
		m2 = new gInt(8,7);
		n1 = new gInt(1,1);
	}

	@AfterClass
	//run after every test
	protected void tearDown() {
		//nothing here
	}

	//add all tests of class to the test suite
	public static Test suite(){
		return new TestSuite( MoneyTest.class );
	}

	//easier to follow what happening and choose which test to add
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest( new MoneyTest( "testReal" ));
		suite.addTest( new MoneyTest( "testImag" ));
		suite.addTest( new MoneyTest( "testAdd" ));
		suite.addTest( new MoneyTest( "testMultiply" ));
		suite.addTest( new MoneyTest( "testNorm" ));
		return suite;
	}

	//Test methods

	public void testReal(){
		//pre-condition: expected's real part is 1, r1's real part is 1
		//post-condition: expected.real() returns 1, r1.real() returns 1
		gInt expected = new gInt(1,2);
		assertNotNull(expected);
		assertEquals(r1.real(), expected.real());
	}

	public void testImag(){
		//pre-condition: expected's imag part is 3, m1's real part is 3
		//post-condition: expected.imag() returns 3, m1.imag() returns 3
		gInt expected = new gInt(3,4)
		assertNotNull(expected);
		assertEquals(m1.imag(), expected.imag());
	}

	public void testAdd(){
		//pre-condition: expected result is 3+5i, the result of sum a1 and a2
		//is 3+5i. expectedneg result is 1+2i, the result of sum a2 and neg1
		//is 1+2i.
		//post-condition: expected result is equal to the sum of a1 and a2.
		//expectedneg result is equal to the sum of neg1 and a2.
		gInt expected = new gInt(3,5);
		gInt expectedneg = new gInt(1,2);
		assertNotNull(expected);
		assertNotNull(expectedneg);

		gInt result35 = a1.add(a2);
		assertNotNull(result35);
		assertEquals(expected, result35);

		result35 = a2.add(a1);
		assertNotNull(result35);
		assertEquals(expected, result35);

		result35 = a2.add(neg1);
		assertNotNull(result35);
		assertEquals(expectedneg, result35);

	public void testMultiply(){
		//pre-condition: expected result is 13+82i, the result of product m1
		//and m2 is 13+82i. expectedneg result is -1-11i ,the result of product m1
		//and neg1 is -1-11i.
		//post-condition: expected result is equal to the sum of m1 and m2.
		//expectedneg result is equal to the sum of neg1 and m1.

		gInt expected = new gInt(13,82);
		gInt expectedneg = new gInt(-1,-11);
		assertNotNull(expected);
		assertNotNull(expectedneg);

		gInt result1382 = m1.multiply(m2);
		assertNotNull(result1382);
		assertEquals(expected, result1382);

		result1382 = m2.multiply(m1);
		assertNotNull(result1382);
		assertEquals(expected, result1382);

		result1382 = m1.multiply(neg1);
		assertNotNull(result1382);
		assertEquals(expectedneg, result1382);
	}

	public void testNorm(){
		//pre-condition: expected result is 1, the L2-norm of n is 1;
		//post-condition: the expected result is equal to the n1.norm()
		float expected = 1;
		assertNotNull(expected);
		
		float result = n1.norm();
		assertNotNull(result);
		assertEquals(expected, result);
	}

	//main
	public static void main( String args[] ) {
		junit.textui.TestRunner.run( suite() );
	}

	public static void main( String args[] ) {
		String[] caseName = { gIntTest.class.getName() };
		junit.textui.TestRunner.main( caseName );
	}
}
