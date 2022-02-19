UPDATE employees_clients AS ec1
SET 
    ec1.employee_id = (SELECT ec.employee_id FROM (SELECT * FROM employees_clients) AS ec
GROUP BY ec.employee_id
ORDER BY COUNT(ec.client_id), ec.employee_id ASC
LIMIT 1)
WHERE
    ec1.employee_id = ec1.client_id;