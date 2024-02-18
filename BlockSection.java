package domain;

import java.util.ArrayList;
import java.util.*;

public class BlockSection {
    private String blockCode;
    private String description;
    private String adviser;

    private int totalStudents;
    private List<Student> studentList;

    public void setBlockCode(String blockCode) {

        this.blockCode = blockCode;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setAdviser(String adviser) {

        this.adviser = adviser;
    }
    public void setTotalStudents(Integer totalStudents){
        this.totalStudents = totalStudents;
    }

    public void setStudentList(List<Student> studentList) {

        this.studentList = studentList;
    }

    public String getBlockCode() {

        return blockCode;
    }

    public String getDescription() {

        return description;
    }

    public String getAdviser() {

        return adviser;
    }
    public int getTotalStudents() {
        return studentList.size();
    }

    public List<Student> getStudentList() {

        return studentList;
    }

    }


