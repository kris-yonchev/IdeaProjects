CREATE TABLE employees_copy
SELECT *
FROM employees
WHERE salary > 30000;
DELETE
FROM employees_copy
WHERE manager_id = 42;
UPDATE employees_copy
SET salary = salary + 5000
WHERE department_id = 1;
SELECT `department_id`, AVG(`salary`) AS 'avh_salary'
FROM employees_copy
GROUP BY `department_id`
ORDER BY department_id ASC;