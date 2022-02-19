SELECT `peak_name`, `river_name`,
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS `mix` FROM peaks, rivers
WHERE SUBSTRING(`peak_name`, -1, 1) = LOWER(SUBSTRING(`river_name`, 1, 1))
ORDER BY `mix`;