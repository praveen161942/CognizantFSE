CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  amount NUMBER, rate NUMBER, years NUMBER
) RETURN NUMBER IS
  monthly_rate NUMBER := rate/100/12;
  n NUMBER := years*12;
BEGIN
  RETURN (amount * monthly_rate) / (1 - POWER(1+monthly_rate, -n));
END;
/
