// Module 1 Day 2 Workshop
package Module1Project.src.Day2Workshop;

public class FixedDepositAccount extends BankAccount {
    private float interest = 3;
    private int interestUpdateCounter = 0;
    private int duration = 6; // in months
    private int durationUpdateCounter = 0;

    // constructors
    public FixedDepositAccount(String name, float balance) {
        setAccountHolderName(name);
        setAccountBalance(balance);
    }
    public FixedDepositAccount(String name, float balance, float intrst) {
        setAccountHolderName(name);
        setAccountBalance(balance);
        interest = intrst;
    }
    public FixedDepositAccount(String name, float balance, float intrst, int dur) {
        this.setAccountHolderName(name);
        this.setAccountBalance(balance);
        interest = intrst;
        duration = dur;
    }

    // getters
    public float getInterest() { return this.interest; }
    public int getDuration() { return this.duration; }

    // setters
    public void setInterest(float intrst) {
        if (this.interestUpdateCounter > 1) {
            throw new IllegalArgumentException(
                "Cannot update interest amount more than once"
            );
        }
        this.interest = intrst;
        interestUpdateCounter++;
    }
    public void setDuration(int dur) {
        if (this.durationUpdateCounter > 1) {
            throw new IllegalArgumentException(
                "Cannot update duration value more than once"
            );
        }
        this.duration = dur;
        durationUpdateCounter++;
    }

    // methods
    @Override
    public void deposit(float amount) { }
    @Override
    public void withdraw(float amount) { }
    public float getBalance() {
        return this.getAccountBalance() + this.getInterest();
    }
}
