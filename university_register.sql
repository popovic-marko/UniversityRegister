/*
SQLyog Community v12.2.1 (64 bit)
MySQL - 5.7.9 : Database - university_register
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`university_register` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `university_register`;

/*Table structure for table `access_token` */

DROP TABLE IF EXISTS `access_token`;

CREATE TABLE `access_token` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `expire` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TOKEN` (`token`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `access_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cityId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `country_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`cityId`),
  KEY `city_country_fk` (`country_fk`),
  CONSTRAINT `city_country_fk` FOREIGN KEY (`country_fk`) REFERENCES `country` (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `contactId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(50) DEFAULT NULL,
  `university_fk` bigint(20) unsigned DEFAULT NULL,
  `contact_type_fk` bigint(20) unsigned DEFAULT NULL,
  `faculty_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`contactId`),
  KEY `contact_contact_type_fk` (`contact_type_fk`),
  KEY `contact_faculty_fk` (`faculty_fk`),
  KEY `contact_university_fk` (`university_fk`),
  CONSTRAINT `contact_contact_type_fk` FOREIGN KEY (`contact_type_fk`) REFERENCES `contact_type` (`contactTypeId`),
  CONSTRAINT `contact_faculty_fk` FOREIGN KEY (`faculty_fk`) REFERENCES `faculty` (`facultyId`) ON DELETE CASCADE,
  CONSTRAINT `contact_university_fk` FOREIGN KEY (`university_fk`) REFERENCES `university` (`universityId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `contact_type` */

DROP TABLE IF EXISTS `contact_type`;

CREATE TABLE `contact_type` (
  `contactTypeId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`contactTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `countryId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) DEFAULT NULL,
  `countryIso` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `faculty` */

DROP TABLE IF EXISTS `faculty`;

CREATE TABLE `faculty` (
  `facultyId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `termsOfEnrollment` varchar(250) DEFAULT NULL,
  `durationOfStudies` varchar(50) DEFAULT NULL,
  `dateOfAccreditation` date DEFAULT NULL,
  `capacity` int(10) DEFAULT NULL,
  `university_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`facultyId`),
  KEY `faculty_university_fk` (`university_fk`),
  CONSTRAINT `faculty_university_fk` FOREIGN KEY (`university_fk`) REFERENCES `university` (`universityId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `management_period` */

DROP TABLE IF EXISTS `management_period`;

CREATE TABLE `management_period` (
  `managingId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dateFrom` date DEFAULT NULL,
  `dateTo` date DEFAULT NULL,
  `position_fk` bigint(20) unsigned DEFAULT NULL,
  `university_fk` bigint(20) unsigned DEFAULT NULL,
  `manager_u_fk` bigint(20) unsigned DEFAULT NULL,
  `faculty_fk` bigint(20) unsigned DEFAULT NULL,
  `manager_f_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`managingId`),
  KEY `management_period_management_position_fk` (`position_fk`),
  KEY `management_period_university_fk` (`university_fk`),
  KEY `management_period_faculty_fk` (`faculty_fk`),
  KEY `management_period_manager_f_fk` (`manager_f_fk`),
  KEY `management_period_manager_u_fk` (`manager_u_fk`),
  CONSTRAINT `management_period_faculty_fk` FOREIGN KEY (`faculty_fk`) REFERENCES `faculty` (`facultyId`) ON DELETE CASCADE,
  CONSTRAINT `management_period_management_position_fk` FOREIGN KEY (`position_fk`) REFERENCES `manager_position` (`positionId`),
  CONSTRAINT `management_period_manager_f_fk` FOREIGN KEY (`manager_f_fk`) REFERENCES `manager` (`managerId`),
  CONSTRAINT `management_period_manager_u_fk` FOREIGN KEY (`manager_u_fk`) REFERENCES `manager` (`managerId`),
  CONSTRAINT `management_period_university_fk` FOREIGN KEY (`university_fk`) REFERENCES `university` (`universityId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `managerId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `rank_fk` bigint(20) unsigned DEFAULT NULL,
  `title_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`managerId`),
  KEY `manager_rank_fk` (`rank_fk`),
  KEY `manager_title_fk` (`title_fk`),
  CONSTRAINT `manager_rank_fk` FOREIGN KEY (`rank_fk`) REFERENCES `rank` (`rankId`),
  CONSTRAINT `manager_title_fk` FOREIGN KEY (`title_fk`) REFERENCES `title` (`titleId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `manager_position` */

DROP TABLE IF EXISTS `manager_position`;

CREATE TABLE `manager_position` (
  `positionId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`positionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `rank` */

DROP TABLE IF EXISTS `rank`;

CREATE TABLE `rank` (
  `rankId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rankId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `title` */

DROP TABLE IF EXISTS `title`;

CREATE TABLE `title` (
  `titleId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`titleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `university` */

DROP TABLE IF EXISTS `university`;

CREATE TABLE `university` (
  `universityId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `dateOfEstablishment` date DEFAULT NULL,
  `city_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`universityId`),
  KEY `university_city_fk` (`city_fk`),
  CONSTRAINT `university_city_fk` FOREIGN KEY (`city_fk`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USERNAME` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
