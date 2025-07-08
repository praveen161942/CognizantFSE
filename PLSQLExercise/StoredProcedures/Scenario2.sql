CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  deptName IN VARCHAR2, bonusPercent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary * (1 + bonusPercent/100)
  WHERE Department = deptName;
  COMMIT;
END;
/
