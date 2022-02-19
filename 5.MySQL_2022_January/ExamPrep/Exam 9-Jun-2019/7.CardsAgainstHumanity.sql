SELECT c.id, CONCAT(c.card_number, ' : ', l.full_name) AS card_token FROM clients AS l
JOIN bank_accounts AS ba ON ba.client_id = l.id
JOIN cards AS c ON c.bank_account_id = ba.id
ORDER BY c.id DESC;