package com.test.java.designpattern.creational.builderpattern;

/*
Builder pattern builds a complex object using simple objects and using a step by step approach. 
This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
Every setter method will return the object created till that time.
*/
public class BuilderPattern {

	public static void main(String[] args) {
		BankAccountBuilder builder = new BankAccountBuilder(1234L)
	            .withOwner("Marge")
	            .atBranch("Springfield")
	            .openingBalance(100)
	            .atRate(2.5)
	            .build();
		System.out.println("Bank Accoun Created");
		
		BankAccountBuilder builderWithLessFields = new BankAccountBuilder(1234L)
	            .withOwner("Marge")
	            .build();
		
		System.out.println("Bank Accoun Created with just one field");
	}
}


class BankAccountBuilder {
	private long accountNumber; //This is important, so we'll pass it to the constructor.
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;
    public BankAccountBuilder(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BankAccountBuilder withOwner(String owner){
        this.owner = owner;
        return this;  //By returning the builder each time, we can create a fluent interface.
    }
    public BankAccountBuilder atBranch(String branch){
        this.branch = branch;
        return this;
    }
    public BankAccountBuilder openingBalance(double balance){
        this.balance = balance;
        return this;
    }
    public BankAccountBuilder atRate(double interestRate){
        this.interestRate = interestRate;
        return this;
    }
    public BankAccountBuilder build(){
        //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
        BankAccountBuilder account = new BankAccountBuilder(accountNumber);  //Since the builder is in the BankAccount class, we can invoke its private constructor.
        account.accountNumber = this.accountNumber;
        account.owner = this.owner;
        account.branch = this.branch;
        account.balance = this.balance;
        account.interestRate = this.interestRate;
        return account;
    }
}