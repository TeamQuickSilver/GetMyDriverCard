package com.quicksilver.getmydrivercard.entities;

import com.quicksilver.getmydrivercard.utils.ApplicationStatus;

import javax.persistence.*;

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

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_images_id")
    private ApplicationImages applicationImages;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ApplicationStatus status;

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
}
