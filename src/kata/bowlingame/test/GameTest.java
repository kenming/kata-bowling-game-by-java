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
	// ���浲�G�ȡG0
	public void testGutterGame() throws Exception {
		int expected = 0;	// ���浲�G��
		int actual;			// ��ڵ��G��
		
		this.rollMany(20, 0);
		actual = g.�p��();
		
		// �_�����
		assertEquals(expected, actual);
	}
	
	@Test
	// ���ժ��a��y�@20���A�C�����u�o�@���ɪ��`�o����
	// ���浲�G�ȡG20
	public void testAllOnes() throws Exception {
		int expected = 20;
		int actual;	
		
		this.rollMany(20, 1);
		actual = g.�p��();
		
		// �_�����
		assertEquals(expected, actual);
	}
		
	@Test
	// ���ժ��a�㧽�u���@���ɤ�+���@�p�����y������
	// �@ 20 ����y���|�A��l 17 ����0��	
	public void testOneSpare() throws Exception {
		int expected = 16;
		int actual;
		
		this.rollSPare();	 //�ɤ�
		g.��y(3);
		this.rollMany(17,0); //��l17����y��0��
		actual = g.�p��();
		
		assertEquals(expected, actual);
	}
	
	private void rollSPare() {
		g.��y(5);
		g.��y(5);
	}
	
	@Test
	// ���ժ��a�㧽�u���@������+���@�p����⦸��y������
	// �@ 19 ����y���|�A��l 16 ����0��
	public void testOneStrike() throws Exception {
		int expected = 24;
		int actual;		
		
		this.rollStrike();
		g.��y(3);
		g.��y(4);
		rollMany(16, 0);
		actual = g.�p��();
		
		assertEquals(expected, actual);
	}
	
	private void rollStrike() {
	    g.��y(10); 
	}
	
	@Test
	// ���ժ��a�b�Ҧ����˪�12����y���`�o���� (����300��)
	public void testPerfectGame() throws Exception {
		int expected = 300;
		int actual;
		
		rollMany(12,10);
		actual = g.�p��();
		
		assertEquals(expected, actual);
	}	
	
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			g.��y(pins);
	}	
}
