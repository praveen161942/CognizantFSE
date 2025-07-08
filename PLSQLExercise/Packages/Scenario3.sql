CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(
    p_accId NUMBER, p_customerId NUMBER, p_type VARCHAR2, p_balance NUMBER
  );
  PROCEDURE CloseAccount(p_accId NUMBER);
  FUNCTION GetTotalBalance(p_customerId NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(
    p_accId NUMBER, p_customerId NUMBER, p_type VARCHAR2, p_balance NUMBER
  ) IS
  BEGIN
    INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_accId, p_customerId, p_type, p_balance, SYSDATE);
  END;

  PROCEDURE CloseAccount(p_accId NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_accId;
  END;

  FUNCTION GetTotalBalance(p_customerId NUMBER) RETURN NUMBER IS
    total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO total
    FROM Accounts
    WHERE CustomerID = p_customerId;
    RETURN NVL(total, 0);
  END;
END AccountOperations;
/
