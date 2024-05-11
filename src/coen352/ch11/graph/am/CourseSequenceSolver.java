package coen352.ch11.graph.am;

import java.io.*;
import java.util.*;

public class CourseSequenceSolver {

    public Graph createGraph() throws IOException {
        String filename = "core_course.gph";
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        Graph graph = new Graphm();
        graph = GraphTest.createGraph(file, graph);

        return graph;
    }

    public String[] getDirectPrerequisite(Graph graph, String course) {

        Integer[] array = graph.getFanIn(getCourseNumber(course));
        String[] arrayNames = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayNames[i] = getCourseName(array[i]);
        }

        return arrayNames;
    }

    public String[] getCourseSequence(Graph graph, String course) {

        Integer[] array = graph.getParentNodes(getCourseNumber(course));

        String[] arrayNames = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayNames[i] = getCourseName(array[i]);
        }

        return arrayNames;
    }

    public boolean isPrerequisite(Graph graph, String sourceCourse, String destinationCourse) {

        boolean valid = false;

        String[] prerequisites = getDirectPrerequisite(graph, destinationCourse);

        for (String name: prerequisites) {
            if (name.equals(sourceCourse)) {
                valid = true;
            }
        }

        return valid;
    }

    public boolean validCourseSequence (String[] expectedCourseSequence, String[] actualCourseSequence) {

        boolean valid = false;

        List<String> expectedCS = new ArrayList<>(Arrays.asList(expectedCourseSequence));
        List<String> actualCS = new ArrayList<>(Arrays.asList(actualCourseSequence));

        Collections.sort(expectedCS);
        Collections.sort(actualCS);

        if (expectedCS.equals(actualCS)) {
            valid = true;
        }

        return valid;
    }

    public String getCourseName(int number) {
        String course = "";
        if (number == 0) {
            course = "MATH204";
        } else if (number == 1) {
            course = "COEN212";
        } else if (number == 2) {
            course = "COEN231";
        } else if (number == 3) {
            course = "COEN243";
        } else if (number == 4) {
            course = "COEN244";
        } else if (number == 5) {
            course = "COEN311";
        } else if (number == 6) {
            course = "COEN313";
        } else if (number == 7) {
            course = "COEN314";
        } else if (number == 8) {
            course = "ELEC273";
        } else if (number == 9) {
            course = "COEN316";
        } else if (number == 10) {
            course = "COEN317";
        } else if (number == 11) {
            course = "COEN346";
        } else if (number == 12) {
            course = "COEN320";
        } else if (number == 13) {
            course = "COEN352";
        } else if (number == 14) {
            course = "COEN366";
        } else if (number == 15) {
            course = "COEN390";
        } else if (number == 16) {
            course = "ENGR290";
        } else if (number == 17) {
            course = "ENGR301";
        } else if (number == 18) {
            course = "COEN490";
        } else if (number == 19) {
            course = "ENGR371";
        } else if (number == 20) {
            course = "SOEN341";
        } else if (number == 21) {
            course = "ELEC242";
        } else if (number == 22) {
            course = "ENGR213";
        } else if (number == 23) {
            course = "ELEC342";
        } else if (number == 24) {
            course = "ELEC372";
        } else if (number == 25) {
            course = "ENCS282";
        } else if (number == 26) {
            course = "ENGR233";
        }

        return course;
    }

    public int getCourseNumber(String course) {
        int number = 0;

        if(course.equals("MATH204")) {
            number = 0;
        } else if (course == "COEN212") {
            number = 1;
        } else if (course.equals("COEN231")) {
            number = 2;
        } else if (course.equals("COEN243")) {
            number = 3;
        } else if (course.equals("COEN244")) {
            number = 4;
        } else if (course.equals("COEN311")) {
            number = 5;
        } else if (course.equals("COEN313")) {
            number = 6;
        } else if (course.equals("COEN314")) {
            number = 7;
        } else if (course.equals("ELEC273")) {
            number = 8;
        } else if (course == "COEN316") {
            number = 9;
        } else if (course == "COEN317") {
            number = 10;
        } else if (course == "COEN346") {
            number = 11;
        } else if (course == "COEN320") {
            number = 12;
        } else if (course == "COEN352") {
            number = 13;
        } else if (course == "COEN366") {
            number = 14;
        } else if (course == "COEN390") {
            number = 15;
        } else if (course == "ENGR290") {
            number = 16;
        } else if (course == "ENGR301") {
            number = 17;
        } else if (course == "COEN490") {
            number = 18;
        } else if (course == "ENGR371") {
            number = 19;
        } else if (course == "SOEN341") {
            number = 20;
        } else if (course == "ELEC242") {
            number = 21;
        } else if (course == "ENGR213") {
            number = 22;
        } else if (course == "ELEC342") {
            number = 23;
        } else if (course == "ELEC372") {
            number = 24;
        } else if (course == "ENCS282") {
            number = 25;
        } else if (course == "ENGR233") {
            number = 26;
        }

        return number;
    }

}