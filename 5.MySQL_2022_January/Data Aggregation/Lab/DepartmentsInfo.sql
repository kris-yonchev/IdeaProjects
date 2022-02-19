SELECT `department_id`, COUNT(`id`) AS 'Average salary' FROM employees
GROUP BY `department_id`
ORDER BY `department_id`;