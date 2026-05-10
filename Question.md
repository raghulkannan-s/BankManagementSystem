# Bank Management System

## Problem Statement

Design and implement a Bank Management System using Java and Object-Oriented Programming concepts. The system should simulate basic banking operations and maintain proper relationships between customers, accounts, transactions, loans, and admin operations.

## Modules to Implement

### 1) Customer Management

**Features**
- Add customer
- View customer details
- Update customer details
- Search customer
- View all customers

**Validations**
- Customer ID must be unique
- Age must be >= 18
- Mobile number must contain 10 digits
- Email must be valid
- Name/address cannot be empty

### 2) Bank Account Management

**Features**
- Create savings/current account
- View account details
- Check balance
- Close account

**Validations**
- Customer must exist
- Initial deposit >= INR 500
- Account number must be unique
- Cannot close account with remaining balance

### 3) Deposit Money

**Features**
- Deposit amount
- Update balance
- Create transaction entry

**Validations**
- Account must exist
- Deposit amount > 0
- Blocked account should not allow deposits

### 4) Withdraw Money

**Features**
- Withdraw amount
- Update balance
- Store transaction

**Validations**
- Sufficient balance required
- Withdrawal amount > 0
- Minimum balance must be maintained
- Blocked account should not allow withdrawal

### 5) Fund Transfer

**Features**
- Transfer funds between accounts
- Update sender/receiver balances
- Maintain transfer history

**Validations**
- Both accounts must exist
- Sender and receiver cannot be same
- Transfer amount > 0
- Sender must have sufficient balance

### 6) Transaction History

**Features**
- Store deposits, withdrawals, transfers
- View account transaction history

**Validations**
- Transaction ID must be unique
- Transaction type must be valid
- Account must exist

### 7) Loan Management

**Features**
- Apply for loan
- Approve/reject loan
- Repay loan
- View loan details

**Validations**
- Customer must exist
- Loan amount > 0
- Loan amount <= INR 10,00,000
- Repayment amount must be valid

### 8) Admin Operations

**Features**
- View all customers/accounts/loans
- Block/unblock account
- Remove inactive customer
- View total bank balance

**Validations**
- Cannot remove customer with active accounts
- Cannot block already blocked account
- Invalid IDs should be handled properly