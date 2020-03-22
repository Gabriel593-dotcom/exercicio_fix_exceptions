package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit){

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(Double amount) {

		this.balance += amount;
	}

	public void withdraw(Double amount) throws DomainException {

		if (withdrawLimit < amount) {

			throw new DomainException("Valor superior ao limite de saque");
		}
		if (this.balance < amount) {

			throw new DomainException("Saldo insuficiente");
		}
		if (amount < 0) {

			throw new DomainException("Erro: Não digite valores negativos.");
		}

		this.balance -= amount;
	}
}
