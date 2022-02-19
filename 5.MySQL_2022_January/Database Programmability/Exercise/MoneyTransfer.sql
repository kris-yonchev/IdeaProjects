DELIMITER ^^
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
IF amount > 0 AND from_account_id != to_account_id AND
(SELECT a.id FROM accounts AS a WHERE a.id = to_account_id) IS NOT NULL AND
(SELECT a.id FROM accounts AS a WHERE a.id = from_account_id) IS NOT NULL THEN
START TRANSACTION;
UPDATE accounts
SET balance = balance - amount
WHERE id = from_account_id;
IF (SELECT a.balance FROM accounts AS a
WHERE a.id = from_account_id) < 0 THEN
ROLLBACK;
ELSE 
UPDATE accounts
SET balance = balance + amount
WHERE id = to_account_id;
COMMIT;
END IF;
END IF;
END
^^