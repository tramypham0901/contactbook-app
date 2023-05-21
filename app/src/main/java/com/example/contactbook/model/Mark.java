package com.example.contactbook.model;

public class Mark {

    private long markId;

    private double markValue;

    private String studentCode;

    private String teacherCode;

    private long markSubjectId;

    private String subjectName;

    private String teacherName;

    private String studentName;

    private String markType;

    private String coefficient;

    private String semester;

    private String feedback;

    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    public double getMarkValue() {
        return markValue;
    }

    public void setMarkValue(double markValue) {
        this.markValue = markValue;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public long getMarkSubjectId() {
        return markSubjectId;
    }

    public void setMarkSubjectId(long markSubjectId) {
        this.markSubjectId = markSubjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", markValue=" + markValue +
                ", studentCode='" + studentCode + '\'' +
                ", teacherCode='" + teacherCode + '\'' +
                ", markSubjectId=" + markSubjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", markType='" + markType + '\'' +
                ", coefficient='" + coefficient + '\'' +
                ", semester='" + semester + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
