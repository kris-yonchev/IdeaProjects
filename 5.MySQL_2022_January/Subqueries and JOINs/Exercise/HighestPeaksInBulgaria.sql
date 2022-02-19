SELECT c.country_code, mountain_range, peak_name, elevation FROM countries AS c
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON p.mountain_id = m.id
WHERE p.elevation > 2835 AND c.country_code = 'BG'
ORDER BY p.elevation DESC;