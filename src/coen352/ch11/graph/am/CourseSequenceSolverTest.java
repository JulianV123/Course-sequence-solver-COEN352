package coen352.ch11.graph.am;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;

class CourseSequenceSolverTest {

    @Test
    public void testGetPrerequisite() throws IOException {

        CourseSequenceSolver courseSequenceSolver = new CourseSequenceSolver();
        String[] actual = courseSequenceSolver.getDirectPrerequisite(courseSequenceSolver.createGraph(), "COEN490");

        //The direct prerequisites for COEN490 (in no particular order) are COEN390, ENGR301, ENGR371, SOEN341.
        String[] expected = {"COEN390","ENGR301","ENGR371","SOEN341"};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetCourseSequence() throws IOException {

        GraphTest.out = new StringBuffer();
        CourseSequenceSolver courseSequenceSolver = new CourseSequenceSolver();
        String[] actual = courseSequenceSolver.getCourseSequence(courseSequenceSolver.createGraph(), "COEN311");

        //The courses you need to take to register for COEN311 are MATH204, then COEN212, then COEN243

        String[] expected = {"MATH204", "COEN212", "COEN243"};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void testIsPrerequisite() throws IOException {
        CourseSequenceSolver courseSequenceSolver = new CourseSequenceSolver();
        Graph graph = courseSequenceSolver.createGraph();
        boolean actual = courseSequenceSolver.isPrerequisite(graph, "COEN244", "COEN311");
        //COEN244 is not a direct prerequisite for COEN311, boolean value should be false.
        boolean expected = false;

        assertEquals(actual, expected);

        boolean actual2 = courseSequenceSolver.isPrerequisite(graph, "COEN212", "COEN311");
        //COEN212 is a direct prerequisite for COEN311, boolean value should be true.
        boolean expected2 = true;

        assertEquals(actual2, expected2);

    }

    @Test
    public void testValidCourseSequence() throws IOException {
        CourseSequenceSolver courseSequenceSolver = new CourseSequenceSolver();
        Graph graph = courseSequenceSolver.createGraph();
        String[] actualCS = {"MATH204", "COEN243"};
        String[] expectedCS = courseSequenceSolver.getCourseSequence(graph, "COEN244");

        boolean actual = courseSequenceSolver.validCourseSequence(expectedCS, actualCS);
        //MATH204 and COEN243 are both needed to take COEN244 (you dont need MATH204 for COEN244, but you do need it
        //for COEN243). The boolean value should return true since both of these classes are present in actualCS.
        boolean expected = true;

        assertEquals(expected, actual);

        String[] actualCS2 = {"MATH204", "COEN243", "COEN212", "COEN231", "COEN311"};
        String[] expectedCS2 = courseSequenceSolver.getCourseSequence(graph, "COEN317");

        boolean actual2 = courseSequenceSolver.validCourseSequence(expectedCS2, actualCS2);
        //To take COEN317, you first need to take MATH204, then COEN212, then COEN243, then COEN231, then COEN311 and COEN313.
        //We are missing COEN313 from the actual course sequence, the boolean value should return false.
        boolean expected2 = false;

        assertEquals(expected2, actual2);
    }

}