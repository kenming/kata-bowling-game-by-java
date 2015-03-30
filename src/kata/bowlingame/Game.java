package kata.bowlingame;

public class Game {
	private int score = 0;
	
	public void 投球(int 瓶數){
		score += 瓶數;
	}
	
	public int 計分(){
		return score;
	}
}