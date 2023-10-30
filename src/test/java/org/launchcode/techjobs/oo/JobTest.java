package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job test = new Job();
        Job test1 = new Job();

        //check that their Id's are distince using assertNotEquals
        assertNotEquals(test, test1);
    }

    //create a job object using constructor to set all fields
    @Test
    public void testJobConstructorSetsAllFields() {

            //assertEquals and assertTrue to test the constructor assignments
            Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertTrue(test.getName() instanceof String);
            assertEquals("Product tester", test.getName());

            assertTrue(test.getEmployer() instanceof Employer);
            assertEquals("ACME", test.getEmployer().getValue());

            assertTrue(test.getLocation() instanceof Location);
            assertEquals("Desert", test.getLocation().getValue());

            assertTrue(test.getPositionType() instanceof PositionType);
            assertEquals("Quality control", test.getPositionType().getValue());

            assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
            assertEquals("Persistence", test.getCoreCompetency().getValue());
        }


        @Test
        public void testJobsForEquality() {
            //Generate two Job objects that have identical field values EXCEPT for id
            Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
            Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
            assertFalse(test.equals(test1));
        }

        @Test
        public void testToStringStartsAndEndsWithNewLine() {
            Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
            char firstChar = test.toString().charAt(0);
            char lastChar = test.toString().charAt(test.toString().length() - 1);
            assertEquals('\n', firstChar);
            assertEquals('\n', lastChar);

        }

        @Test
        public void testToStringContainsCorrectLabelsAndData() {
            Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
            String job = test.toString();
            assertEquals ("\nID: " + test.getId()+ '\n' +
                            "Name: " + test.getName() + '\n' +
                            "Employer: " + test.getEmployer() + '\n' +
                            "Location: " + test.getLocation() + '\n' +
                            "Position Type: " + test.getPositionType() + '\n' +
                            "Core Competency: " + test.getCoreCompetency() + '\n', job);

        }
        @Test
    public void testToStringHandlesEmptyField() {
            Job test = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
            String job = test.toString();
            assertEquals("\nID: " + test.getId()+ '\n' +
                    "Name: " + "Data not available" + '\n' +
                    "Employer: " + test.getEmployer() + '\n' +
                    "Location: " + test.getLocation() + '\n' +
                    "Position Type: " + test.getPositionType() + '\n' +
                    "Core Competency: " + test.getCoreCompetency() + '\n', job);
        }

    }