SELECT MAX(sd.speed) AS 'max_speed', tws.name FROM skills_data as sd
RIGHT JOIN players AS p ON p.skills_data_id = sd.id
RIGHT JOIN teams AS t ON p.team_id = t.id
RIGHT JOIN stadiums as s ON t.stadium_id = s.id
RIGHT JOIN towns AS tws ON tws.id = s.town_id
WHERE t.name != 'Devify'
GROUP BY tws.name
ORDER BY max_speed DESC, tws.name;
