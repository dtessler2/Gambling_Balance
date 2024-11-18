package assignment_4_Final;

public class GamblingBalance {
	private double balance;
	private double minBalance;
	IRandomValueGenerator rv;
	
	public GamblingBalance(double minBalance, IRandomValueGenerator rv) {
		balance = 0;
		this.minBalance = minBalance;
		this.rv = rv;
	}
	
	public double getCurrentBalance() {
		return balance;
	}
	
	public boolean canBet(double amnt) {
		//If balance is above min by at least amnt, can place bet
		if((balance - minBalance) >= amnt) {
			return true;
		}
		return false;
	}
	
	public void addMoney(double amnt) {
		if(amnt < 0) {
			throw new IllegalArgumentException("Input cannot be negative.");
		}
		balance += amnt;
	}
	
	public double betOnANumber(double amnt, double min, double max, double selectedNumber) {
		double amntChanged;
		double randNum = rv.randNumInRange(min, max);
		//If the bet loses
		if(randNum != selectedNumber) {
			if((balance - amnt) < minBalance) {
				return 0;
			}
			amntChanged = amnt * -1;
			balance -= amnt;
		}
		else {
			//If the bet wins
			amntChanged = (max - min) * amnt;
			balance += amntChanged;
		}
		
		return amntChanged;
	}
	
	//amnt = amount bet that the event will occur
	//p = actual probability of event occuring
	public double betOnProbability(double amnt, double p) {
		if(p > 1 || p < 0) {
			throw new IllegalArgumentException("Invalid input.");
		}
		boolean status = rv.getTrueWithProbability(p);
		double amntChanged;
		if(status) {
			amntChanged = ((Math.pow(p, -1)) - 1) * amnt;
			balance += amntChanged;
		}
		else {
			if(balance - amnt < minBalance) {
				return 0;
			}
			amntChanged = -1 * amnt;
			balance -= amnt;
		}
		return amntChanged;
	}
	
}

