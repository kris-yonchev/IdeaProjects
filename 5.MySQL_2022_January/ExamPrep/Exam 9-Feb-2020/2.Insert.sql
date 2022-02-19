INSERT INTO coaches (`first_name`, `last_name`, `salary`, `coach_level`)
SELECT p.first_name, p.last_name, p.salary, CHAR_LENGTH(p.first_name) FROM players AS p
WHERE p.age >=45;
