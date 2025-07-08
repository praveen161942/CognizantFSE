CREATE OR REPLACE PROCEDURE TransferFunds(
  fromAcc IN NUMBER, toAcc IN NUMBER, amount IN NUMBER
) AS
  insufficient EXCEPTION;
BEGIN
  UPDATE Accounts
  SET Balance = Balance - amount
  WHERE AccountID = fromAcc AND Balance >= amount;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE insufficient;
  END IF;

  UPDATE Accounts
  SET Balance = Balance + amount
  WHERE AccountID = toAcc;

  COMMIT;

EXCEPTION
  WHEN insufficient THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: insufficient balance.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
