package kata.bowlingame.test;

import static org.junit.Assert.*;
import org.junit.*;
import kata.bowlingame.*;

public class GameTest {
	private Game g;		// 宣告參考變數，指向 Game instance
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	@Test
	// 測試玩家投球共20次全洗溝 (gutter)時的總得分數
	// 期望結果值：0
	public void testGutterGame() throws Exception {
		int expected = 0;	// 期望結果值
		int actual;			// 實際結果值
		
		this.rollMany(20, 0);
		actual = g.計分();
		
		// 斷言比對
		assertEquals(expected, actual);
	}
	
	@Test
	// 測試玩家投球共20次，每次都只得一分時的總得分數
	// 期望結果值：20
	public void testAllOnes() throws Exception {
		int expected = 20;
		int actual;	
		
		this.rollMany(20, 1);
		actual = g.計分();
		
		// 斷言比對
		assertEquals(expected, actual);
	}
		
	@Test
	// 測試玩家整局只有一次補中+次一計分格投球的分數
	// 共 20 次投球機會，其餘 17 次皆0分	
	public void testOneSpare() throws Exception {
		int expected = 16;
		int actual;
		
		this.rollSPare();	 //補中
		g.投球(3);
		this.rollMany(17,0); //其餘17次投球皆0分
		actual = g.計分();
		
		assertEquals(expected, actual);
	}
	
	private void rollSPare() {
		g.投球(5);
		g.投球(5);
	}
	
	@Test
	// 測試玩家整局只有一次全中+次一計分格兩次投球的分數
	// 共 19 次投球機會，其餘 16 次皆0分
	public void testOneStrike() throws Exception {
		int expected = 24;
		int actual;		
		
		this.rollStrike();
		g.投球(3);
		g.投球(4);
		rollMany(16, 0);
		actual = g.計分();
		
		assertEquals(expected, actual);
	}
	
	private void rollStrike() {
	    g.投球(10); 
	}
	
	@Test
	// 測試玩家在所有全倒的12次投球的總得分數 (滿分300分)
	public void testPerfectGame() throws Exception {
		int expected = 300;
		int actual;
		
		rollMany(12,10);
		actual = g.計分();
		
		assertEquals(expected, actual);
	}	
	
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			g.投球(pins);
	}	
}
