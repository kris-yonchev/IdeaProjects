DELIMITER ^^
CREATE PROCEDURE usp_get_employees_by_salary_level(level_of_salary VARCHAR(7))
BEGIN
SELECT first_name, last_name FROM employees AS e
WHERE ufn_get_salary_level(e.salary) = level_of_salary
ORDER BY e.first_name DESC, e.last_name DESC;
END
^^