package kata.bowlingame;

public class Game {
	private int rolls[] = new int[21];
	private int currentRoll = 0;
		
	public void ��y(int �~��){
		rolls[currentRoll++] = �~��;
	}
	
	public int �p��(){
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
	
	// �P�_�O�_���ɤ� (Spare)
	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] +
				rolls[frameIndex +1 ] == 10;
	}
}