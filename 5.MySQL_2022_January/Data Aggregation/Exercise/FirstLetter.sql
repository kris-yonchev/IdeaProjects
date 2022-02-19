SELECT DISTINCT LEFT(`first_name`, 1) AS 'first_letter' FROM wizzard_deposits
WHERE `deposit_group` = 'Troll chest'
GROUP BY `first_letter`
ORDER BY `first_letter` ASC;