package unitTestingExercise.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseExtendedTest {

    private static final Person PERSON_FOR_TEST = new Person(131313, "Pesho");

    Database database;
    Person person;

    @Before
    public void prep() throws OperationNotSupportedException {
        database = new Database(PERSON_FOR_TEST);
    }

    @Test
    public void databaseShouldCreateDatabase() {
        Person[] people = database.getElements();
        Assert.assertEquals(people[0], PERSON_FOR_TEST);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForOneOrMoreUsersWithSameID() throws OperationNotSupportedException {

        database.add(PERSON_FOR_TEST);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForNullPerson() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForNoSuchUserPresent() throws OperationNotSupportedException {
        database.findByUsername("Gasho");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForPersonWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void databaseShouldThrowExceptionForUserWithNoSuchId () throws OperationNotSupportedException {
        database.findById(PERSON_FOR_TEST.getId());
    }


}