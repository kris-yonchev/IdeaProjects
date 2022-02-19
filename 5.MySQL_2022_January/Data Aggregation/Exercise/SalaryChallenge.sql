SELECT `e1`.`first_name`, `e1`.`last_name`, `e1`.`department_id`
FROM employees AS `e1`
JOIN (SELECT e2.department_id, AVG(e2.salary) AS dep_avg_salary
FROM employees as `e2`
GROUP BY e2.department_id) AS e3 ON e1.department_id = e3.department_id
WHERE e1.salary > e3.dep_avg_salary
ORDER BY department_id LIMIT 10;