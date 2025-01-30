package com.rossacheson.springboot.validationdemo;

import com.rossacheson.springboot.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message="is required")
    @Size(min=2, message="must have at least 2 characters")
    private String lastName;
    @NotNull(message="is required")
    @Min(value=0, message="Must be greater than or equal to zero")
    @Max(value=10, message="Must be less than or equal to ten")
    private Integer freePasses;
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;
    @CourseCode(value="RDA", message = "Must start with RDA")
    private String courseCode;
    public Customer(){}

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
