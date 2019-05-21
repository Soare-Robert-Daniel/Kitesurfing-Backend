-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- Dumping structure for table test.favorites
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '0',
  `spotId` int(10) unsigned DEFAULT 0,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table test.favorites: ~2 rows (approximately)
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` (`id`, `username`, `spotId`) VALUES
	(4, 'Dudu', 5),
	(5, 'Dudu', 100);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;

-- Dumping structure for table test.location_id
CREATE TABLE IF NOT EXISTS `location_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `longitude` float DEFAULT 0,
  `latitude` float DEFAULT 0,
  `windProbability` int(3) DEFAULT 0,
  `country` varchar(50) DEFAULT '0',
  `whenToGo` varchar(50) DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;

-- Dumping data for table test.location_id: ~73 rows (approximately)
/*!40000 ALTER TABLE `location_id` DISABLE KEYS */;
INSERT INTO `location_id` (`id`, `name`, `longitude`, `latitude`, `windProbability`, `country`, `whenToGo`) VALUES
	(1, 'Futuna', -178.123, -14.3056, 86, 'Cook Islands', 'AUGUST'),
	(2, 'Shelley Point', 17.95, -32.71, 86, 'South Africa', 'JANUARY'),
	(3, 'Anakao', 43.646, -23.6717, 87, 'South Africa', 'APRIL'),
	(4, 'Cubagua', -64.16, 10.82, 87, 'Venezuela', 'APRIL'),
	(5, 'Fishermen\'s Bay', 59.67, 22.03, 87, 'Oman', 'AUGUST'),
	(6, 'Pocitas Beach', -81.08, -4.11, 87, 'Ecuador', 'OCTOBER'),
	(7, 'Zapara', -71.5667, 10.9866, 87, 'Venezuela', 'AUGUST'),
	(8, '2nd Bay', -9.78, 31.48, 88, 'Morocco', 'AUGUST'),
	(9, 'Adicora', -69.8, 11.93, 88, 'Venezuela', 'AUGUST'),
	(10, 'Bahia de San Pedro', -63.98, 10.8, 88, 'Venezuela', 'APRIL'),
	(11, 'Bunker Beach', 115.04, -33.54, 88, 'Australia', 'JANUARY'),
	(12, 'Dolphin beach, Guns', 14.54, -22.8445, 88, 'South Africa', 'OCTOBER'),
	(13, 'Essaouira', -9.7636, 31.5019, 88, 'Morocco', 'AUGUST'),
	(14, 'Isla Holbox', -87.25, 21.55, 88, 'Mexico', 'APRIL'),
	(15, 'Nunura', -81.12, -5.84, 88, 'Ecuador', 'APRIL'),
	(16, 'Diego Suarez - Baie d\'Andovokonko', 49.3968, -12.2889, 89, 'Tanzania', 'OCTOBER'),
	(17, 'Langebaan', 18.03, -33.08, 89, 'South Africa', 'JANUARY'),
	(18, 'Observatory Beach', 121.77, -33.9, 89, 'Australia', 'JANUARY'),
	(19, 'Phan Thiet', 108.8, 10.7, 89, 'Viet Nam', 'AUGUST'),
	(20, 'Pimentel', -79.93, -6.84, 89, 'Peru', 'APRIL'),
	(21, 'Sidi Abdellah', -9.47, 31.9, 89, 'Morocco', 'AUGUST'),
	(22, 'Alibaba', -22.97, 16.71, 90, 'Senegal', 'APRIL'),
	(23, 'Bandy Creek', 122, -33.82, 90, 'Australia', 'JANUARY'),
	(24, 'Barra Grande', -41.4117, -2.91, 90, 'Brazil', 'AUGUST'),
	(25, 'Bequia', -61.24, 13.01, 90, 'Guadeloupe', 'APRIL'),
	(26, 'Punta Abreojos', -113.57, 26.7, 90, 'Mexico', 'APRIL'),
	(27, 'Farwah', 11.7, 33.12, 91, 'Libya', 'AUGUST'),
	(28, 'Jeddah, South Corniche', 39.3508, 20.8704, 91, 'Saudi Arabia', 'AUGUST'),
	(29, 'Lagoon', 108.95, 10.54, 91, 'Viet Nam', 'AUGUST'),
	(30, 'Puerto Caballos', -75.49, -14.94, 91, 'Peru', 'APRIL'),
	(31, 'Fourth Mile Beach', 121.82, -33.89, 92, 'Australia', 'JANUARY'),
	(32, 'Kaliantan Lombok', 116.484, -8.9156, 92, 'Indonesia', 'AUGUST'),
	(33, 'Limassol, Anemometer', 33.0235, 34.652, 92, 'United Kingdom', 'AUGUST'),
	(34, 'Los Roques', -66.67, 11.95, 92, 'Venezuela', 'APRIL'),
	(35, 'Namena Island', 179.1, -17.1098, 92, 'New Zealand', 'APRIL'),
	(36, 'Zanzibar / Ras Nungwi', 39.2986, -5.7229, 92, 'Tanzania', 'JANUARY'),
	(37, 'Al Mirfa', 53.4844, 24.1026, 93, 'United Arab Emirates', 'AUGUST'),
	(38, 'Dakar', -17.43, 14.67, 93, 'Senegal', 'APRIL'),
	(39, 'Exmouth (Dunes)', 114.139, -21.8002, 93, 'Australia', 'OCTOBER'),
	(40, 'Geraldton', 114.6, -28.76, 93, 'Australia', 'OCTOBER'),
	(41, 'Point Moore', 114.57, -28.78, 93, 'Australia', 'OCTOBER'),
	(42, 'Walvis Bay', 14.48, -22.9, 93, 'South Africa', 'OCTOBER'),
	(43, 'Cabo de La Vela', -72.1479, 12.1934, 94, 'Venezuela', 'APRIL'),
	(44, 'DOSC, Dubai Offshore Sailing Club', 55.2153, 25.1758, 94, 'United Arab Emirates', 'AUGUST'),
	(45, 'HERZLIA SEA SCOUTS', 34.8007, 32.1737, 94, 'Israel', 'AUGUST'),
	(46, 'Sal / Santa Maria', -22.909, 16.592, 94, 'Senegal', 'APRIL'),
	(47, 'Shark Bay', 18.0452, -33.1135, 94, 'South Africa', 'JANUARY'),
	(48, 'Sorobon', -68.23, 12.09, 94, 'Venezuela', 'APRIL'),
	(49, 'Adam\'s Bridge', 79.5686, 9.0869, 95, 'Sri Lanka', 'AUGUST'),
	(50, 'Boa Vista', -22.8, 16.1, 95, 'Senegal', 'APRIL'),
	(51, 'Gazebo Point', 58.91, 20.66, 95, 'Oman', 'AUGUST'),
	(52, 'Kalpitiya', 79.7017, 8.081, 95, 'Sri Lanka', 'AUGUST'),
	(53, 'Kappalady', 79.706, 8.1408, 95, 'Sri Lanka', 'AUGUST'),
	(54, 'North Obhur, Danah Jed', 39.0616, 21.7483, 95, 'Saudi Arabia', 'AUGUST'),
	(55, 'Oualidia-Lagune', -9.04, 32.74, 95, 'Morocco', 'AUGUST'),
	(56, 'Lavanono', 44.93, -25.42, 96, 'South Africa', 'OCTOBER'),
	(57, 'Androka', 44.06, -25.02, 97, 'South Africa', 'OCTOBER'),
	(58, 'Dakhla', -15.854, 23.74, 97, 'Spain', 'AUGUST'),
	(59, 'Heliophora Lagoon', -15.8564, 23.6371, 97, 'Spain', 'AUGUST'),
	(60, 'Golden Beach', 33.7209, 27.3136, 98, 'Egypt', 'AUGUST'),
	(61, 'Tamania (Cap 8)', -14.8393, 25.0817, 98, 'Spain', 'AUGUST'),
	(62, 'Jericoacoara', -40.51, -2.79, 99, 'Brazil', 'AUGUST'),
	(63, 'Laayoune', -13.44, 27.03, 99, 'Spain', 'AUGUST'),
	(64, 'Marsa El Brega', 20.0764, 30.8995, 99, 'Libya', 'AUGUST'),
	(65, '27-Waam', 66.8381, 24.4681, 100, 'India', 'APRIL'),
	(66, 'Barra Nova', -38.1499, -4.1008, 100, 'Brazil', 'AUGUST'),
	(67, 'Cumbuco', -38.7299, -3.6246, 100, 'Brazil', 'AUGUST'),
	(68, 'Galinhos', -36.29, -5.08, 100, 'Brazil', 'AUGUST'),
	(69, 'Guajiru', -39.2312, -3.2389, 100, 'Brazil', 'AUGUST'),
	(70, 'Ilha do Guajiru', -39.9086, -2.8806, 100, 'Brazil', 'AUGUST'),
	(71, 'Paracas, Kangaroo Kite Shack', -76.2552, -13.8589, 100, 'Peru', 'OCTOBER'),
	(72, 'Socotra Island - Qualansiyah', 53.57, 12.72, 100, 'Oman', 'AUGUST'),
	(73, 'Westpunt (Westpoint)', -70.0594, 12.6164, 100, 'Venezuela', 'APRIL');
/*!40000 ALTER TABLE `location_id` ENABLE KEYS */;

-- Dumping structure for table test.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '0',
  `password` varchar(50) DEFAULT '0',
  `token` varchar(50) DEFAULT '0',
  `reset_password_token` varchar(50) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table test.users: ~5 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `token`, `reset_password_token`) VALUES
	(1, 'Vlad', 'Tepes', 'fc8d29a4-4b32-4287-9823-8e6a813fc6da', NULL),
	(2, 'Roby', 'Ninonino', 'ca2c0a86-a92b-4651-af46-ad7389326ede', NULL),
	(3, 'Roby', 'Ninonino', '37cd3b23-75a0-499e-be9e-80f51353a4c3', NULL),
	(4, 'Dudu', 'salam', '199dba89-6625-4964-90b8-3531fbb4fe56', NULL),
	(5, 'Ratata', 'salam', '6f8ec628-8772-4fd8-8dcf-91b9b134f758', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
