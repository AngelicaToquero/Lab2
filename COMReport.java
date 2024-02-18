package domain;

import java.io.FileNotFoundException;
import java.util.*;

public class COMReport {
    public static void main(String [] args) throws FileNotFoundException{
        StringBuilder a = new StringBuilder();
        BlockSectionDA blockSectionDA = new BlockSectionDA();

        for(BlockSection blockSection: blockSectionDA.getBlockSectionList()){

            a.append("Block section code: ").append(blockSection.getBlockCode()).append("\n");
            a.append("Description: ").append(blockSection.getDescription()).append("\n");
            a.append("Adviser: ").append(blockSection.getAdviser()).append("\n\n");


            a.append("Total Students: ").append(blockSection.getTotalStudents()).append("\n\n");
            List<Student> stud= blockSection.getStudentList();
            for(Student student: stud) {
            a.append("Student number: ").append(student.getStudentNumber()).append("\n");
            a.append("Student Name: ").append(student.getName()).append("\n");
            a.append("Program: ").append(student.getProgram()).append("\n");
            a.append("Total units enrolled: ").append(student.getTotalUnitsEnrolled()).append("\n\n");

            List<Course> cors = student.getCourseList();

            a.append(String.format("%-10s %-20s %-10s %-5s %-15s",
                    "Course", "Description", "Units", "Day", "Time"));
                for (Course course : cors) {
                    a.append("\n");
                    a.append(String.format("%-10s %-20s %-10s %-5s %-15s",
                            course.getCourseCode(), course.getDescription(),
                            course.getUnit(), course.getDay(), course.getTime()));



            }
                a.append("\n");
                a.append("\n");
        }

        }
        System.out.println(a);

    }
}



