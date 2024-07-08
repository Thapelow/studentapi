package com.goosenvi.studentapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "Students")
public class StudentInfo {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "PK_ID")
    private Long id;
    @Column(name = "STUDENT_ID")
    private Long studentId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PROGRAMME")
    private String programme;

    @ElementCollection
    @CollectionTable(name = "Student_Courses", joinColumns = @JoinColumn(name = "STUDENT_ID"))
    @Column(name = "COURSES")
    private List<String> courses;

    public StudentInfo(Long studentId, String firstName, String lastName, String email, List<String> courses, String programme) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
        this.programme = programme;
    }

    public StudentInfo() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getStudentInformation(){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String course: courses) {
            stringJoiner.add(course);
        }
        return "StudentId: " + studentId + " FirstName: " + firstName + " LastName: " + lastName + " Email: " + email + " Program: " + programme+ " Courses: " + stringJoiner.toString();
    }
}
