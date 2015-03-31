package kata.bowlingame;

public class Game {
	private int rolls[] = new int[21];
	private int currentRoll = 0;
		
	public void 投球(int 瓶數){
		rolls[currentRoll++] = 瓶數;
	}
	
	public int 計分(){
		int score = 0;
	    int frameIndex = 0;
	    for (int frame = 0; frame < 10; frame++) {
	    	if (isSpare(frameIndex))
	    	{
	    		score += 10 + rolls[frameIndex + 2];
	    		frameIndex += 2;
	    	} else {
	    		score += rolls[frameIndex] + 
	    				rolls[frameIndex + 1];
	    		frameIndex += 2;
	    	}
	    }

		return score;
	}
	
	// 判斷是否為補中 (Spare)
	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] +
				rolls[frameIndex +1 ] == 10;
	}
}