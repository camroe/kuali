package test.com.company;

import com.company.ElevatorController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * ElevatorController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mar 24, 2015</pre>
 */
public class ElevatorControllerTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConstructor() throws Exception {
        ElevatorController ec = new ElevatorController(1);
        assertNotNull("Elevator Controller should not be null", ec);
    }

    /**
     * Method: Request(int fromFloor)
     */
    @Test
    public void testRequest() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: reportFloor(int elevator, int floor)
     */
    @Test
    public void testReportFloor() throws Exception {
//TODO: Test goes here... 
    }

} 
