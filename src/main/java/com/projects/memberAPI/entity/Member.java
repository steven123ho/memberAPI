package com.projects.memberAPI.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table
@Entity(name = "member")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberID;

    @Version
    @Column(nullable = false)
    private Long version = 0L;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String enrollmentDate;
    private String planName;
    private String planType;
    private String coverageLevel;
    private BigDecimal premium;
    private Integer deductible;
    private Integer outOfPocketMax;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String gender;
    private Boolean smoker;
    private String preExistingConditions;
    private String notes;
    private String lastClaimDate;
    private BigDecimal claimAmount;


    // Getters and setters for all fields
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public Integer getDeductible() {
        return deductible;
    }

    public void setDeductible(Integer deductible) {
        this.deductible = deductible;
    }

    public Integer getOutOfPocketMax() {
        return outOfPocketMax;
    }

    public void setOutOfPocketMax(Integer outOfPocketMax) {
        this.outOfPocketMax = outOfPocketMax;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public String getPreExistingConditions() {
        return preExistingConditions;
    }

    public void setPreExistingConditions(String preExistingConditions) {
        this.preExistingConditions = preExistingConditions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLastClaimDate() {
        return lastClaimDate;
    }

    public void setLastClaimDate(String lastClaimDate) {
        this.lastClaimDate = lastClaimDate;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }



}
