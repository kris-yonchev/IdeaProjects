DELIMITER **
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
UPDATE employees AS e
SET e.salary = e.salary * 1.05
WHERE e.employee_id = id;
END
**