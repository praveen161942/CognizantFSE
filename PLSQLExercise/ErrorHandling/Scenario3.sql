CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER
) AS
  dup_customer EXCEPTION;
BEGIN
  INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_id || ' already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
END;
/
