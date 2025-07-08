CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog(LogID, TransactionID, LogDate)
  VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, SYSDATE);
END;
/
