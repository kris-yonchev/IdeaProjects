CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
UPDATE products AS p
JOIN reviews AS r ON r.id = p.review_id
JOIN categories AS c ON c.id = p.category_id
SET price = price * 0.7
WHERE r.rating < 4 AND c.name = category_name;
END;