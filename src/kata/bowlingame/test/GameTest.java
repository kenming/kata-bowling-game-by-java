package kata.bowlingame.test;

import static org.junit.Assert.*;
import org.junit.*;
import kata.bowlingame.*;

public class GameTest {
	private Game g;		// �ŧi�Ѧ��ܼơA���V Game instance
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	@Test
	// ���ժ��a��y�@20�����~�� (gutter)�ɪ��`�o����
	public void testGutterGame() throws Exception {
		int expected = 0;	// ���浲�G��
		int actual;			// ��ڵ��G��
		
		for (int i=0;i<20;i++){
			g.��y(0);
		}
		actual = g.�p��();
		
		// �_�����
		assertEquals(expected, actual);
	}
}
