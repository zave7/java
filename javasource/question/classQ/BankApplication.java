package com.kitri.question.classQ;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택 > ");
			 
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void withdraw() {
		System.out.println("--------\n출금\n--------");
		String ano;
		System.out.print("계좌번호 : ");
		ano = scanner.next();
		Account findAccount = findAccount(ano);
		int balance;
		System.out.print("출금액 : ");
		balance = scanner.nextInt();
		findAccount.setBalance(findAccount.getBalance()+balance);
	}

	private static void deposit() {
		System.out.println("--------\n예금\n--------");
		String ano;
		System.out.print("계좌번호 : ");
		ano = scanner.next();
		Account findAccount = findAccount(ano);
		int balance;
		System.out.print("예금액 : ");
		balance = scanner.nextInt();
		findAccount.setBalance(findAccount.getBalance()+balance);

	}

	private static void accountList() {
		System.out.println("--------\n계좌목록\n--------");
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i]!=null) {
			System.out.println(accountArray[i].getAno() +" "+ accountArray[i].getOwner() +" "+ accountArray[i].getBalance());
			} else {
				break;
			}
		}
	}

	private static void createAccount() {
		System.out.println("--------\n계좌생성\n--------");
		String ano;
		String owner;
		int balance;
		System.out.print("계좌번호 : ");
		ano = scanner.next();
		System.out.print("계좌주 : ");
		owner = scanner.next();
		System.out.print("초기입금액 : ");
		balance = scanner.nextInt();
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i]==null) {
				accountArray[i] = new Account(ano, owner, balance);
				break;
			}
		}
	}
	private static Account findAccount(String ano) {
		for(int i = 0; i <= accountArray.length; i++) {
			if(ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			}
		}
		return null;
	}
}
