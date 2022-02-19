SELECT tc.job_during_journey AS job_name FROM travel_cards AS tc
WHERE tc.journey_id = (SELECT j.id FROM journeys AS j
			ORDER BY DATEDIFF(j.journey_end, j.journey_start) DESC
			LIMIT 1)
GROUP BY tc.job_during_journey
ORDER BY COUNT(tc.job_during_journey) ASC
LIMIT 1;
