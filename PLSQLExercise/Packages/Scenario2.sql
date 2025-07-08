CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2,
    p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE
  );
  PROCEDURE UpdateEmployeeDetails(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2
  );
  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2,
    p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE
  ) IS
  BEGIN
    INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_department, p_hiredate);
  END;

  PROCEDURE UpdateEmployeeDetails(
    p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2
  ) IS
  BEGIN
    UPDATE Employees
    SET Name = p_name, Position = p_position
    WHERE EmployeeID = p_id;
  END;

  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    monthly NUMBER;
  BEGIN
    SELECT Salary INTO monthly FROM Employees WHERE EmployeeID = p_id;
    RETURN monthly * 12;
  END;
END EmployeeManagement;
/
