package com.nnf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class AppUserDTO {

    @JsonProperty("id")
    private Integer id;

    @NotNull
    @NotEmpty
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @JsonProperty("last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @JsonProperty("year_of_birth")
    private Integer yearOfBirth;

    @NotNull
    @NotEmpty
    @JsonProperty("citizen_country_code")
    private String citizenCountryCode;

    @NotNull
    @NotEmpty
    @JsonProperty("password")
    private String password;

    @NotNull
    @NotEmpty
    @JsonProperty("matching_password")
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @JsonProperty("email")
    private String email;

    @NotNull
    @NotEmpty
    @JsonProperty("matching_email")
    private String matchingEmail;

    @NotNull
    @NotEmpty
    @JsonProperty("phone_country_code")
    private String phoneCountryCode;

    @NotNull
    @NotEmpty
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("roles")
    private List<String> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatchingEmail() {
        return matchingEmail;
    }

    public void setMatchingEmail(String matchingEmail) {
        this.matchingEmail = matchingEmail;
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
