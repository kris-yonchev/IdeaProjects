SELECT b.name, COUNT(rd.id) AS count_of_cards FROM branches AS b
LEFT JOIN employees AS e ON b.id = e.branch_id
LEFT JOIN employees_clients AS ec ON e.id = ec.employee_id
LEFT JOIN clients AS l ON l.id = ec.client_id
LEFT JOIN bank_accounts AS ba ON ba.client_id = l.id
LEFT JOIN cards AS rd ON rd.bank_account_id = ba.id
GROUP BY b.name
ORDER BY count_of_cards DESC, b.name; 