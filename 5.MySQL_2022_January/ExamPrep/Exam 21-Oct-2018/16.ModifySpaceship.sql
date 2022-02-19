DELIMITER ^^
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
BEGIN
START TRANSACTION;
	IF (SELECT COUNT(ss.name) FROM spaceships AS ss WHERE ss.name = spaceship_name > 0) THEN
	UPDATE spaceships AS ss
	SET ss.light_speed_rate = ss.light_speed_rate + light_speed_rate_increse
	WHERE ss.name = spaceship_name;
	ELSE
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
    ROLLBACK;
    END IF;

END;
^^