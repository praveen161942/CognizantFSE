DECLARE
  CURSOR c IS SELECT AccountID FROM Accounts;
BEGIN
  FOR rec IN c LOOP
    UPDATE Accounts SET Balance=Balance-100 WHERE AccountID=rec.AccountID;
  END LOOP;
  COMMIT;
END;
/
