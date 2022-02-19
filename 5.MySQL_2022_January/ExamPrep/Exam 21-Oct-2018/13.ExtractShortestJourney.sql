SELECT j.id, p.name AS planet_name, sp.name AS spaceport_name, j.purpose AS journey_purpose FROM journeys AS j
JOIN spaceports AS sp ON sp.id = j.destination_spaceport_id
JOIN planets AS p ON p.id = sp.planet_id
WHERE DATEDIFF(j.journey_end, j.hourney_start)
LIMIT 1;