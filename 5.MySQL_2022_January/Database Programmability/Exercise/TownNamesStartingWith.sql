DELIMITER ^^
CREATE PROCEDURE usp_get_towns_starting_with(similarity VARCHAR(10))
BEGIN
SELECT t.name AS 'town_name' FROM towns AS t
WHERE t.name LIKE CONCAT(similarity,'%')
ORDER BY town_name;
END
^^