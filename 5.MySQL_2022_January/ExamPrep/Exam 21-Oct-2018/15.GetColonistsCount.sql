CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN (SELECT COUNT(c.id) FROM colonists AS c
JOIN travel_cards AS tc ON tc.colonist_id = c.id
JOIN journeys AS j ON j.id = tc.journey_id
JOIN spaceports AS sp ON j.destination_spaceport_id = sp.id
JOIN planets AS p ON p.id = sp.planet_id
WHERE p.name = planet_name);