CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  accBal NUMBER;
BEGIN
  SELECT Balance INTO accBal FROM Accounts WHERE AccountID = :NEW.AccountID;

  IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > accBal THEN
    RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds balance.');
  ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
  END IF;
END;
/
