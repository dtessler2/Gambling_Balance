package assignment_4_Final;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TEST_GamblingBalance {

	private MockRandomValueGenerator mockRand;
	private GamblingBalance gb;
	
	@BeforeEach
	void setUp() {
		mockRand = new MockRandomValueGenerator();
		gb = new GamblingBalance(0, mockRand);
	}
	
	@Test
	void testGamblingBalance() {
		assertEquals(0, gb.getCurrentBalance());
		gb.addMoney(10);
		assertEquals(10, gb.getCurrentBalance());
	}
	
	@Test
	void addMoney() {
		gb.addMoney(10);
		assertEquals(10, gb.getCurrentBalance());
	}
	
	@Test
	void addNegativeAmnt() {
		assertThrows(IllegalArgumentException.class, () -> gb.addMoney(-10), "Input cannot be negative.");
	}
	
	@Test
	void testCanBet() {
		gb.addMoney(100);
		assertTrue(gb.canBet(50));
	}
	
	@Test
	void betAmountGreaterThanDifferenceBetweenCurrentBalanceAndMinBalance() {
		gb.addMoney(10);
		assertFalse(gb.canBet(100));
	}
	
	@Test
	void betAmntEqualsCurrentBalance() {
		gb.addMoney(20);
		assertTrue(gb.canBet(gb.getCurrentBalance()));
	}
		
	@Test
	void losingBetWithBalanceMinusAmountUnderMinBalance() {
		mockRand.setMockNum(10);
		gb.addMoney(5);
		assertEquals(0, gb.betOnANumber(10, 5, 15, 11));
	}
	
	@Test 
	void losingBetWithBalanceMinusAmountEqualToMinBalance() {
		gb.addMoney(100);
		mockRand.setMockNum(15);
		assertEquals(-100, gb.betOnANumber(100, 10, 20, 11));
	}
	
	@Test
	void testIfBetWins() {
		mockRand.setMockNum(7);
		assertEquals(800, gb.betOnANumber(100, 2, 10, 7));
	}
	
	@Test 
	void testIfBetLoses() {
		gb.addMoney(200);
		mockRand.setMockNum(20);
		assertEquals(-100, gb.betOnANumber(100, 10, 30, 11));
	}
	
	@Test
	void testBetOnProbabilityEqualsOne() {
		mockRand.setMockProbability(.5);
		assertEquals(0, gb.betOnProbability(100, 1));
	}
	
	@Test 
	void illegalProbability() {
		assertThrows(IllegalArgumentException.class, () -> gb.betOnProbability(100, 10), "Probability cannot be greater than 1 or less than 0.");
	}
	
	@Test
	void randomProbabilityLessThanActualProbability() {
		mockRand.setMockProbability(0.1);
		assertEquals(400, gb.betOnProbability(100, 0.2));
	}
	
	@Test
	void losingBetOnProbabilityWithAmountGreaterThanBalanceMinusMinbalance() {
		gb.addMoney(15);
		mockRand.setMockProbability(0.7);
		assertEquals(0, gb.betOnProbability(16, 0.5));
	}
	

}
