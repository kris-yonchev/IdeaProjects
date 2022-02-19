SELECT e.first_name, e.last_name, t.name AS 'town', a.address_text FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY first_name ASC, last_name LIMIT 5;