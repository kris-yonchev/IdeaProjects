SELECT c.continent_code, c.currency_code, COUNT(*) AS 'currency_usage'
FROM countries AS c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage > 1 AND currency_usage = (
SELECT COUNT(*) AS cu
FROM countries AS c2
WHERE c.continent_code = c2.continent_code
GROUP BY c2.currency_code
ORDER BY cu DESC
LIMIT 1)
ORDER BY c.continent_code, c.currency_code;
