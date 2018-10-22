package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;

@Entity
@Table(name = "applications_images")
public class ApplicationImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_images_id")
    private Long applicationImagesId;

    @Column(name = "person_image")
    private byte[] personImage;

    @Column(name = "previous_card_image")
    private byte[] previousCardImage;

    @Column(name = "identity_card_image")
    private byte[] identityCardImage;

    @Column(name = "driving_license_image")
    private byte[] drivingLicenseImage;

    @Column(name = "euro_card_image")
    private byte[] euroCardImage;

    @Column(name = "signature_image")
    private byte[] signatureImage;
}
