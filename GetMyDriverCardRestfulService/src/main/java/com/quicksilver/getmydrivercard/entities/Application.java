package com.quicksilver.getmydrivercard.entities;

import com.quicksilver.getmydrivercard.utils.ApplicationReason;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_images_id")
    private ApplicationImages applicationImages;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason")
    private ApplicationReason reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApplicationStatus status;

    @Column(name = "date_of_submission")
    private Date dateOfSubmission;

    @Column(name = "lost_place")
    private String lostPlace;

    @Column(name = "lost_date")
    private Date lostDate;

    @Column(name = "date_of_expire")
    private Date dateOfExpire;


    public Application() {

    }

    public Application(Person person, User user, ApplicationImages applicationImages, Date dateOfSubmission) {
        this.person = person;
        this.user = user;
        this.applicationImages = applicationImages;
        this.dateOfSubmission = dateOfSubmission;
        this.status = ApplicationStatus.NEW;
        this.reason = ApplicationReason.NEW;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ApplicationImages getApplicationImages() {
        return applicationImages;
    }

    public void setApplicationImages(ApplicationImages applicationImages) {
        this.applicationImages = applicationImages;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public ApplicationReason getReason() {
        return reason;
    }

    public void setReason(ApplicationReason reason) {
        this.reason = reason;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    public Date getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(Date dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }
}
