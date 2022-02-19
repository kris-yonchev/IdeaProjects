SELECT `town_id`, `name` FROM towns
WHERE NOT `name` REGEXP '^R|^B|^D'
ORDER BY `name`;