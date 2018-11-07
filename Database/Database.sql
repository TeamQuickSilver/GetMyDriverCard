-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.22-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for getmydrivercard
CREATE DATABASE IF NOT EXISTS `getmydrivercard` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `getmydrivercard`;

-- Dumping structure for table getmydrivercard.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.addresses: 3 rows
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`address_id`, `address`, `city`, `district`) VALUES
	(1, 'Moskovska Str.22', 'Sofia', 'Sofia'),
	(2, 'Georgi Benkovski Str.7', 'Plovdiv', 'Plovdiv'),
	(3, 'Ivan Vazov Str.54', 'Lovech', 'Lovech');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.applications
CREATE TABLE IF NOT EXISTS `applications` (
  `application_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_of_submission` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `application_images_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date_of_expire` datetime DEFAULT NULL,
  `lost_date` datetime DEFAULT NULL,
  `lost_place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  KEY `FKlwfwt4tq3egre0qm2yiogla5q` (`application_images_id`),
  KEY `FKc0f6bttcvq4gek6aspj1kll9d` (`person_id`),
  KEY `FKfsfqljedcla632u568jl5qf3w` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.applications: 3 rows
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` (`application_id`, `date_of_submission`, `reason`, `status`, `application_images_id`, `person_id`, `user_id`, `date_of_expire`, `lost_date`, `lost_place`) VALUES
	(1, '2018-11-06 00:00:00', 'NEW', 'NEW', 1, 1, 18, '2020-11-06 00:00:00', NULL, NULL),
	(2, '2018-11-05 00:00:00', 'NEW', 'NEW', 2, 2, 17, '2020-11-05 00:00:00', NULL, NULL),
	(3, '2018-11-01 00:00:00', 'NEW', 'NEW', 3, 3, 17, '2020-11-01 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.applications_images
CREATE TABLE IF NOT EXISTS `applications_images` (
  `application_images_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `driving_license_image` tinyblob,
  `euro_card_image` tinyblob,
  `identity_card_image` tinyblob,
  `person_image` tinyblob,
  `previous_card_image` tinyblob,
  `signature_image` tinyblob,
  PRIMARY KEY (`application_images_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.applications_images: 3 rows
/*!40000 ALTER TABLE `applications_images` DISABLE KEYS */;
INSERT INTO `applications_images` (`application_images_id`, `driving_license_image`, `euro_card_image`, `identity_card_image`, `person_image`, `previous_card_image`, `signature_image`) VALUES
	(1, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `applications_images` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.driver_licenses
CREATE TABLE IF NOT EXISTS `driver_licenses` (
  `id_driver_license` bigint(20) NOT NULL,
  `identity_card_number` bigint(20) DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `issued_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id_driver_license`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.driver_licenses: 3 rows
/*!40000 ALTER TABLE `driver_licenses` DISABLE KEYS */;
INSERT INTO `driver_licenses` (`id_driver_license`, `identity_card_number`, `issued_by`, `issued_on`) VALUES
	(643232190, 622098695, 'MVR LOVECH', '2017-03-10 00:00:00'),
	(455304932, 772098695, 'MVR SOFIA', '2016-09-01 00:00:00'),
	(214304932, 672098694, 'MVR PLOVDIV', '2017-09-01 00:00:00');
/*!40000 ALTER TABLE `driver_licenses` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.identity_cards
CREATE TABLE IF NOT EXISTS `identity_cards` (
  `identity_card_number` bigint(20) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `fathers_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `issued_on` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `personal_number` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`identity_card_number`),
  KEY `FKfctqwowxi25iull50796mxsk7` (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.identity_cards: 3 rows
/*!40000 ALTER TABLE `identity_cards` DISABLE KEYS */;
INSERT INTO `identity_cards` (`identity_card_number`, `date_of_birth`, `fathers_name`, `first_name`, `issued_by`, `issued_on`, `last_name`, `personal_number`, `address_id`) VALUES
	(622098695, '1994-05-11 00:00:00', 'Ivanov', 'Georgi', 'MVR LOVECH', '2015-04-02 00:00:00', 'Petkov', 9610098695, 1),
	(772098695, '1988-10-22 00:00:00', 'Dimitrov', 'Ivan', 'MVR SOFIA', '2016-10-10 00:00:00', 'Ivanov', 8810228695, 2),
	(672098694, '1989-02-03 00:00:00', 'Lyudmilov', 'Samuil', 'MVR PLOVDIV', '2016-04-14 00:00:00', 'Zahariev', 8902036951, 3);
/*!40000 ALTER TABLE `identity_cards` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.persons
CREATE TABLE IF NOT EXISTS `persons` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `id_driver_license` bigint(20) DEFAULT NULL,
  `identity_card_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FKka1aadt0gc3yd2t18miomq75e` (`id_driver_license`),
  KEY `FK6yrr198ogdnbt2recwasjk6xm` (`identity_card_number`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.persons: 3 rows
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` (`person_id`, `email`, `phone_number`, `id_driver_license`, `identity_card_number`) VALUES
	(1, 'samuil_1996@abv.bg', 892123211, 643232190, 622098695),
	(2, 'ivanov@gmail.com', 892124982, 455304932, 772098695),
	(3, 'gerogiev88@mail.bg', 887624982, 214304932, 672098694);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.role
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.role: 2 rows
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `authority`) VALUES
	(1, 'USER'),
	(2, 'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table getmydrivercard.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK4qu1gr772nnf6ve5af002rwya` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table getmydrivercard.users: 3 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `email`, `password`, `role_id`) VALUES
	(18, 'samuilzahariev96@abv.bg', NULL, 1),
	(19, 'SamuilZ', '$2a$10$fScnTurtoB87OaQbhwODvuBcflpRAFzSgSYxKeuXQHtYbjOZxKaje', 2),
	(17, 'samuilzahariev96@gmail.com', NULL, 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
