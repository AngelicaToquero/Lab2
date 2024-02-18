package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.util.*;
public class CourseDA {
    private List<Course> courseList;
    public List<Course> getCourseList() {
        return courseList;
    }

    public CourseDA(String studentNumber) throws FileNotFoundException{

        Scanner courseInfo = new Scanner(
                new FileReader("src/domain/scheduleInfo.csv"));

        courseList = new ArrayList<Course>();

        while(courseInfo.hasNext()) {
            String rowCourse = new String();
            rowCourse = courseInfo.nextLine();

            String[] rowCourseSpecific = new String[6];
            rowCourseSpecific = rowCourse.split(",");

            if(studentNumber.equals(rowCourseSpecific[0])){
                Course course = new Course();

                course.setCourseCode(rowCourseSpecific[1].trim());
                course.setDescription(rowCourseSpecific[2].trim());
                course.setUnit(Integer.parseInt(rowCourseSpecific[3].trim()));
                course.setDay(rowCourseSpecific[4].trim());
                course.setTime(rowCourseSpecific[5].trim());

                courseList.add(course);
            }
        }
        courseInfo.close();
    }

}
