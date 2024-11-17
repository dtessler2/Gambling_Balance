package assignment_4_Final;

public class MockRandomValueGenerator implements IRandomValueGenerator {

	private int randNum;
	private int p;
	
	@Override
	public int randNumInRange(int min, int max) {
		return randNum;
	}

	@Override
	public boolean getTrueWithProbability(double probability) {
		if(p <= (probability * 100)) {
			return true;
		}
		return false;
	}
	
	public void setMockNum(int randNum) {
		this.randNum = randNum;
	}
	
	public void setMockProbability(int p) {
		this.p = p * 100;
	}

}
