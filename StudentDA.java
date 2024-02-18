package domain;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
public class StudentDA {
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }
    public StudentDA(String blockCode) throws FileNotFoundException {
        Scanner studentInfo = new Scanner(new FileReader
                ("src/domain/studentInfo.csv"));
        studentList = new ArrayList<>();

        while (studentInfo.hasNext()) {
            String rowStudent = new String();
            rowStudent = studentInfo.nextLine();

            String[] rowStudentSpecific = new String[4];
            rowStudentSpecific = rowStudent.split(",");
            if (rowStudentSpecific[0].trim().equals(blockCode)) {

                Student student = new Student();

                student.setStudentNumber(rowStudentSpecific[1].trim());
                student.setName(rowStudentSpecific[2].trim());
                student.setProgram(rowStudentSpecific[3].trim());

                CourseDA courseDA = new CourseDA(student.getStudentNumber());

                student.setCourseList(courseDA.getCourseList());
                studentList.add(student);
            }

        }
        studentInfo.close();
    }
}

