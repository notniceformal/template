package com.nnf.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "Application_Users")
public class AppUser {

    @NotNull
    @NotEmpty
    @Id
    @JsonProperty(value = "email")
    private String email;

    @NotNull
    @NotEmpty
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "last_name")
    private String lastName;

    @NotNull
    @JsonProperty(value = "year_of_birth")
    private Integer yearOfBirth;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "citizen_country_code")
    private String citizenCountryCode;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "password")
    private String password;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "phone_country_code")
    private String phoneCountryCode;

    @NotNull
    @NotEmpty
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @JsonProperty("roles")
    @ElementCollection(targetClass = String.class)
    private List<String> roles;

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

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCitizenCountryCode() {
        return citizenCountryCode;
    }

    public void setCitizenCountryCode(String citizenCountryCode) {
        this.citizenCountryCode = citizenCountryCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
