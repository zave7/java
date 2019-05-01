package com.kitri.question.classQ;

public class Account {
//	첫번째 문제
//	private int balance;
//	public static final int MIN_BALANCE = 0;
//	public static final int MAX_BALANCE = 1000000;
//	
//	public void setBalance(int balance) {
//		if(balance < MIN_BALANCE ) {
//			this.balance = MIN_BALANCE;
//		} else if(balance > MAX_BALANCE){
//			this.balance = MAX_BALANCE;
//		} else {
//			this.balance = balance;
//		}
//	}
//	public int getBalance() {
//		return balance;
//	}
//	두번째 문제
	private String ano;
	private String owner;
	private int balance;
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
