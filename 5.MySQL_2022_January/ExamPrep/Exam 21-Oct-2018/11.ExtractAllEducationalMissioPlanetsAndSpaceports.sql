SELECT p.name, sp.name FROM planets AS p
JOIN spaceports AS sp ON sp.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = sp.id
WHERE j.purpose = 'Educational'
ORDER BY sp.name DESC;