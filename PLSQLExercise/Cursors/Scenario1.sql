DECLARE
  CURSOR c IS
    SELECT AccountID, Amount, TransactionDate FROM Transactions
    WHERE TransactionDate >= TRUNC(SYSDATE,'MM');
BEGIN
  FOR rec IN c LOOP
    DBMS_OUTPUT.PUT_LINE('Account: '||rec.AccountID||', Amount: '||rec.Amount||
                         ', Date: '||TO_CHAR(rec.TransactionDate,'YYYY-MM-DD'));
  END LOOP;
END;
/
