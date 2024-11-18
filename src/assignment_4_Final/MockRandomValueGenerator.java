package assignment_4_Final;

public class MockRandomValueGenerator implements IRandomValueGenerator {

	private double randNum;
	private double p;
	
	@Override
	public double randNumInRange(double min, double max) {
		return randNum;
	}

	@Override
	public boolean getTrueWithProbability(double probability) {
		if(p <= (probability * 100)) {
			return true;
		}
		return false;
	}
	
	public void setMockNum(double randNum) {
		this.randNum = randNum;
	}
	
	public void setMockProbability(double p) {
		this.p = p * 100;
	}

}
