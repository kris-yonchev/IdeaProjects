SELECT COUNT(tc.id) AS count FROM journeys AS j
JOIN travel_cards AS tc ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';