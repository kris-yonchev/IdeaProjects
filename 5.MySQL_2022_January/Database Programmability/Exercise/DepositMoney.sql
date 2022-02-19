DELIMITER ^^
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
IF money_amount > 0
THEN 
UPDATE accounts AS a
SET a.balance = a.balance + money_amount
WHERE a.id = account_id;
END IF;
END
^^