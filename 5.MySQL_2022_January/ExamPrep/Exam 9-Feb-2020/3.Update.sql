UPDATE coaches
SET coach_level = coach_level + 1
WHERE first_name LIKE 'A%' AND (SELECT COUNT(*) FROM players_coaches
WHERE coach_id = coaches.id) > 0;