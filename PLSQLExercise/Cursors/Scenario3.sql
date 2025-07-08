DECLARE
  CURSOR c IS SELECT LoanID, InterestRate FROM Loans;
BEGIN
  FOR rec IN c LOOP
    UPDATE Loans
    SET InterestRate = rec.InterestRate + 0.5
    WHERE LoanID = rec.LoanID;
  END LOOP;
  COMMIT;
END;
/
