CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN (SELECT COUNT(p.id) AS 'count' FROM players AS p
JOIN teams AS t ON t.id = p.team_id
JOIN stadiums AS s ON t.stadium_id = s.id
WHERE s.name = stadium_name)