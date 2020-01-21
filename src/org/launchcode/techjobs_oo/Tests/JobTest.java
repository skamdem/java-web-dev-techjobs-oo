package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

//for testToStringMethod
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JobTest {
    Job test_job1, test_job2, test_job3, test_job4, same_test_job4, test_job5, test_job6;

    @Before
    public void createCarObject() {
        test_job1 = new Job("Junior Quantitative Developer", new Employer("Xtra Securities Inc."), new Location("New York City"), new PositionType("C++ developer"), new CoreCompetency("C++, AWS, DevOps"));
        test_job2 = new Job("Software Architect", new Employer("Advanced Trading Capital Inc."), new Location("New York City"), new PositionType("Java developer"), new CoreCompetency("Java Concurrency, Python"));
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        same_test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job("Product tester", null, new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job6 = new Job(null, null, null, null, null);
    }

    //Num 1
    @Test
    public void testSettingJobId(){
        System.out.println(test_job1);
        System.out.println(test_job2);
        //assertEquals(test_job1.getId(), 1);
        assertTrue(test_job2.getId() == test_job1.getId() + 1);
    }

    //Num 2
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(test_job3.getName(), "Product tester");
        try {
            Class<?> employer = Class.forName("org.launchcode.techjobs_oo.Employer");
            assertEquals(test_job3.getEmployer().getClass().getName(), employer.getName());
            assertEquals(test_job3.getEmployer().getValue(), "ACME");

            Class<?> positionType = Class.forName("org.launchcode.techjobs_oo.PositionType");
            assertEquals(test_job3.getPositionType().getClass().getName(), positionType.getName());
            assertEquals(test_job3.getPositionType().getValue(), "Quality control");

            Class<?> coreCompetency = Class.forName("org.launchcode.techjobs_oo.CoreCompetency");
            assertEquals(test_job3.getCoreCompetency().getClass().getName(), coreCompetency.getName());
            assertEquals(test_job3.getCoreCompetency().getValue(), "Persistence");

            Class<?> location = Class.forName("org.launchcode.techjobs_oo.Location");
            //assertEquals(testJob.getLocation().getClass().getName(), location.getName());
            assertTrue(test_job3.getLocation() instanceof Location);
            assertEquals(test_job3.getLocation().getValue(), "Desert");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Num 3
    @Test
    public void testJobsForEquality(){
        assertFalse(test_job4.equals(same_test_job4));
    }

    //Num 4
    @Test
    public void testToStringMethodContainsBlankLineBeforeAndAfter(){
        String pattern = "\n(.*)\n";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(test_job1.toString());
        assertTrue(m.find());
    }

    //Num 5
    @Test
    public void testToStringMethodContainsLabelForEachField(){
        String pattern = "(.*)ID:(.*)\n" +
                "Name:(.*)\n" +
                "Employer:(.*)\n" +
                "Location:(.*)\n" +
                "Position Type:(.*)\n" +
                "Core Competency:(.*)\n";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(test_job1.toString());
        //System.out.println(test_job1.toString());
        assertTrue(m.find());
    }

    @Test
    public void testToStringMethodContainsDataNotAvailableForEmptyField(){
        assertTrue(test_job5.toString().contains("Data not available"));
    }

    @Test
    public void testToStringMethodContainsOnlyIDField(){
        assertTrue(test_job6.toString().contains("OOPS! This job does not seem to exist."));
    }
}
