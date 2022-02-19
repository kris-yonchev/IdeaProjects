DELIMITER ^^
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS BIT
DETERMINISTIC
BEGIN
DECLARE current_index INT DEFAULT 1;
DECLARE word_length INT DEFAULT CHAR_LENGTH(word);

WHILE current_index < word_length + 1
DO
IF LOCATE(SUBSTRING(word, current_index, 1), set_of_letters ) < 1
THEN RETURN 0;
END IF;
SET current_index = current_index + 1;
END WHILE;
RETURN 1;
END
^^