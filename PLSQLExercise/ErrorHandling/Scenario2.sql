CREATE OR REPLACE PROCEDURE UpdateSalary(
  empId IN NUMBER, percent IN NUMBER
) AS
  no_employee EXCEPTION;
BEGIN
  UPDATE Employees
  SET Salary = Salary * (1 + percent/100)
  WHERE EmployeeID = empId;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE no_employee;
  END IF;

  COMMIT;

EXCEPTION
  WHEN no_employee THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || empId || ' not found.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/
