CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN (SELECT COUNT(rd.id) AS cards FROM clients AS c
JOIN bank_accounts AS ba ON c.id = ba.client_id
JOIN cards AS rd ON ba.id = rd.bank_account_id
WHERE c.full_name = name);