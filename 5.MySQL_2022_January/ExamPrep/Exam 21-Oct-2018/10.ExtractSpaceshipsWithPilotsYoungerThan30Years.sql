SELECT ss.name, ss.manufacturer FROM spaceships AS ss
JOIN journeys AS j ON j.spaceship_id = ss.id
JOIN travel_cards AS tc ON tc.journey_id = j.id
JOIN colonists AS c ON c.id = tc.colonist_id
WHERE tc.job_during_journey = 'Pilot' AND YEAR(c.birth_date) >= 1989
ORDER BY ss.name;
