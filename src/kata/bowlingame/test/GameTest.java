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
	public void testGutterGame() throws Exception {
		int expected = 0;	// 期望結果值
		int actual;			// 實際結果值
		
		for (int i=0;i<20;i++){
			g.投球(0);
		}
		actual = g.計分();
		
		// 斷言比對
		assertEquals(expected, actual);
	}
}
