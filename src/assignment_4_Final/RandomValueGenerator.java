package assignment_4_Final;
import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator{

	Random rand;
	
	public RandomValueGenerator() {
		rand = new Random();
	}
	
	@Override
	public double randNumInRange(double min, double max) {
		return rand.nextDouble((max + 1) - min) + min;
	}

	@Override
	public boolean getTrueWithProbability(double probability) {
		double randNum = rand.nextDouble(100 + 1);
		if(randNum <= (probability * 100)) {
			return true;
		}
		return false;
	}

}
