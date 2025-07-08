CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  fromAcc IN NUMBER, toAcc IN NUMBER, amount IN NUMBER
) AS
  insufficient_funds EXCEPTION;
BEGIN
  UPDATE Accounts
  SET Balance = Balance - amount
  WHERE AccountID = fromAcc AND Balance >= amount;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE insufficient_funds;
  END IF;

  UPDATE Accounts
  SET Balance = Balance + amount
  WHERE AccountID = toAcc;

  COMMIT;

EXCEPTION
  WHEN insufficient_funds THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient funds.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
