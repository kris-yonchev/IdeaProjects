CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN
(SELECT COUNT(op.product_id) AS total_products FROM customers AS c
JOIN orders AS o ON o.customer_id = c.id
JOIN orders_products AS op ON op.order_id = o.id
WHERE c.first_name = name);