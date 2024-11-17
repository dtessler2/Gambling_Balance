package assignment_4_Final;
import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator{

	Random rand;
	
	public RandomValueGenerator() {
		rand = new Random();
	}
	
	@Override
	public int randNumInRange(int min, int max) {
		return rand.nextInt((max + 1) - min) + min;
	}

	@Override
	public boolean getTrueWithProbability(double probability) {
		int randNum = rand.nextInt(100 + 1);
		if(randNum <= (probability * 100)) {
			return true;
		}
		return false;
	}

}
