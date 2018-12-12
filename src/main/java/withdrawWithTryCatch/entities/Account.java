package withdrawWithTryCatch.entities;

import withdrawWithTryCatch.exception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance+=amount;
    }

    public void withdraw(Double amount) throws DomainException {

        if(balance-amount<0){
            throw  new DomainException("Insufficient balance");
        }
        if(amount>withdrawLimit){
            throw new DomainException("You have not Limit!");
        }

        balance-=amount;
    }

    public Double getBalance(){
        return balance;
    }

}
