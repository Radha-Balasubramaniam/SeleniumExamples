package encapsulation;

public class Bank {
	
	public int accountNo = 123456;
	private int  pinNo = 1234;
	private double balanceAmount = 1000000;
	
	
	public void withdrawAmount(int accNo, int pin, int amount) {
		if(accNo==accountNo && pin==pinNo) {
			if(amount <= balanceAmount) {
				
			} else {
				System.out.println("Insufficient balance");
			}
		} else {
			System.out.println("Incorrect Details");
		}
	}
	
	public void updatePIN(int accNo, int oldPin, int newPin) {
		
		if(accNo==accountNo && oldPin==pinNo) {
			pinNo = newPin;
			System.out.println("Pin updated");
		}
		else {
			System.out.println("Invalid Credentials");
		}
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}

}
