-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2025 at 06:49 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dental`
--
CREATE DATABASE IF NOT EXISTS `dental` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dental`;

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `clinic_dentist_id` int(11) NOT NULL,
  `appointment_date` date NOT NULL,
  `total_amount` decimal(12,2) NOT NULL,
  `status` varchar(100) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `appointment_items`
--

CREATE TABLE `appointment_items` (
  `id` int(11) NOT NULL,
  `appointment_id` int(11) NOT NULL,
  `dentist_item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE `blogs` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `snippet` text NOT NULL,
  `content` text NOT NULL,
  `post_date` date NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`id`, `title`, `slug`, `snippet`, `content`, `post_date`, `image`) VALUES
(1, 'Dental Examination: First Step to a Healthy Smile', 'dental-examination-first-step-to-healthy-smile', 'Learn about the importance of regular dental check-ups and what to expect during your visit.', 'Regular dental examinations are crucial for maintaining optimal oral health. During your visit, our experienced dentists will thoroughly assess your oral health, identify potential issues early, and create a personalized treatment plan to ensure your smile stays healthy and bright.', '2024-07-19', '/images/heroDoctors.png'),
(2, 'Teeth Whitening: Tips for a Brighter Smile', 'teeth-whitening-tips-for-brighter-smile', 'Everything you need to know about teeth whitening procedures.', 'Teeth whitening procedures are aesthetic treatments designed to restore your teeth\'s natural color. Learn about the treatment process, products used, and care recommendations for maintaining your bright smile.', '2024-07-20', '/images/orthodontia.jpg'),
(3, 'Bridges and Crowns: Best Solutions for Your Teeth', 'bridges-and-crowns-best-solutions-for-your-teeth', 'Everything about bridge and crown treatments.', 'Bridges and crowns are dental treatments used to restore missing teeth. In this article, learn how these procedures are performed and when they might be the right choice for you.', '2024-07-21', '/images/maxillofacialSurgery.jpg'),
(4, 'Orthodontic Treatment: Align Your Teeth', 'orthodontic-treatment-align-your-teeth', 'Understanding orthodontic treatment process and benefits.', 'Orthodontic treatment is designed to straighten your teeth and improve jaw alignment. Learn about braces, wires, and other orthodontic appliances that can help you achieve a perfect smile.', '2024-07-22', '/images/implant.jpg'),
(5, 'Pediatric Dentistry: Healthy Teeth from an Early Age', 'pediatric-dentistry-healthy-teeth-from-early-age', 'The importance and applications of pediatric dentistry.', 'Pediatric dentistry focuses on protecting and supporting children\'s dental health. Learn about early dental care and treatment methods to ensure your child\'s healthy smile.', '2024-07-23', '/images/dentalRestoration.jpg'),
(6, 'Dental Implants: Permanent Tooth Solutions', 'dental-implants-permanent-tooth-solutions', 'Dental implants and implementation processes.', 'Dental implants provide permanent solutions for missing teeth. Learn how implant procedures are performed and discover their advantages in this comprehensive guide.', '2024-07-24', '/images/pediatricDentistry.jpg'),
(7, 'Gum Disease: Symptoms and Treatment Methods', 'gum-disease-symptoms-and-treatment-methods', 'Understanding gum disease symptoms and treatment options.', 'Gum disease occurs when tissues around the teeth become inflamed. Learn about the symptoms, causes, and treatment methods to maintain healthy gums.', '2024-07-25', '/images/teethWhitening.jpg'),
(8, 'Tooth Decay: Prevention and Treatment Methods', 'tooth-decay-prevention-and-treatment-methods', 'Methods for preventing and treating tooth decay.', 'Tooth decay is damage that occurs to tooth enamel. Discover effective methods for preventing cavities and learn about available treatment options for existing decay.', '2024-07-26', '/images/toothExtraction.jpg'),
(9, 'What to Consider When Choosing a Dentist?', 'what-to-consider-when-choosing-a-dentist', 'Important factors to consider when selecting a dentist.', 'Choosing the right dentist is crucial for your dental health. Learn about the key factors to consider when selecting a dental professional who best meets your needs.', '2024-07-27', '/images/aestheticDentistry.jpg'),
(10, 'Dental Cleaning: Professional Cleaning and Care', 'dental-cleaning-professional-cleaning-and-care', 'Dental cleaning and care recommendations.', 'Professional dental cleaning is an essential step in maintaining oral health. Learn about professional cleaning procedures and home care methods for optimal dental hygiene.', '2024-07-28', '/images/rootCanal.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `clinics`
--

CREATE TABLE `clinics` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `district` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `open_hours` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clinics`
--

INSERT INTO `clinics` (`id`, `name`, `address`, `district`, `phone`, `open_hours`) VALUES
(1, 'Tuen Mun Clinic', '2/F, Yan Oi Polyclinic\r\n6 Tuen Lee Street, Tuen Mun', 'Tuen Mun', '24523261', 'Mon-Fri 9:00-18:00'),
(2, 'Tsuen Wan Clinic', '14/F, Tsuen Wan Government Offices\r\n38 Sai Lau Kok Road, Tsuen Wan', 'Tsuen Wan', '24176512', 'Mon-Fri 9:00-18:00'),
(3, 'Tai Po Clinic', '1 Po Wu Lane, Tai Po', 'Tai Po', '22223261', 'Mon-Fri 9:00-18:00'),
(4, 'Sai Kung Clinic', '1/F Mona Fong Clinic\r\n23 Man Nin Street, Sai Kung', 'Sai Kung', '24156512', 'Mon-Fri 9:00-18:00'),
(5, 'Fanling Clinic', '3/F, Fanling Health Centre\r\n2 Pik Fung Road, Fanling', 'Fanling', '26711046', 'Mon-Fri 9:00-18:00');

-- --------------------------------------------------------

--
-- Table structure for table `clinic_dentists`
--

CREATE TABLE `clinic_dentists` (
  `id` int(11) NOT NULL,
  `clinic_id` int(11) NOT NULL,
  `dentist_id` int(11) NOT NULL,
  `day_of_week` enum('Mon','Tue','Wed','Thu','Fri') NOT NULL,
  `time_slot_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clinic_dentists`
--

INSERT INTO `clinic_dentists` (`id`, `clinic_id`, `dentist_id`, `day_of_week`, `time_slot_id`) VALUES
(1, 1, 1, 'Mon', 1),
(2, 1, 1, 'Mon', 2),
(3, 1, 1, 'Mon', 3),
(4, 1, 2, 'Mon', 4),
(5, 1, 2, 'Mon', 5),
(6, 1, 2, 'Mon', 6),
(7, 1, 2, 'Mon', 7),
(8, 1, 3, 'Tue', 1),
(9, 1, 3, 'Tue', 2),
(10, 1, 3, 'Tue', 3),
(11, 1, 4, 'Tue', 4),
(12, 1, 4, 'Tue', 5),
(13, 1, 4, 'Tue', 6),
(14, 1, 4, 'Tue', 7),
(15, 1, 5, 'Wed', 1),
(16, 1, 5, 'Wed', 2),
(17, 1, 5, 'Wed', 3),
(18, 1, 6, 'Wed', 4),
(19, 1, 6, 'Wed', 5),
(20, 1, 6, 'Wed', 6),
(21, 1, 6, 'Wed', 7),
(22, 1, 7, 'Thu', 1),
(23, 1, 7, 'Thu', 2),
(24, 1, 7, 'Thu', 3),
(25, 1, 8, 'Thu', 4),
(26, 1, 8, 'Thu', 5),
(27, 1, 8, 'Thu', 6),
(28, 1, 8, 'Thu', 7),
(29, 1, 9, 'Fri', 1),
(30, 1, 9, 'Fri', 2),
(31, 1, 9, 'Fri', 3),
(32, 1, 10, 'Fri', 4),
(33, 1, 10, 'Fri', 5),
(34, 1, 10, 'Fri', 6),
(35, 1, 10, 'Fri', 7),
(39, 2, 1, 'Mon', 4),
(40, 2, 1, 'Mon', 5),
(41, 2, 1, 'Mon', 6),
(42, 2, 1, 'Mon', 7),
(36, 2, 2, 'Mon', 1),
(37, 2, 2, 'Mon', 2),
(38, 2, 2, 'Mon', 3),
(46, 2, 3, 'Tue', 4),
(47, 2, 3, 'Tue', 5),
(48, 2, 3, 'Tue', 6),
(49, 2, 3, 'Tue', 7),
(43, 2, 4, 'Tue', 1),
(44, 2, 4, 'Tue', 2),
(45, 2, 4, 'Tue', 3),
(53, 2, 5, 'Wed', 4),
(54, 2, 5, 'Wed', 5),
(55, 2, 5, 'Wed', 6),
(56, 2, 5, 'Wed', 7),
(50, 2, 6, 'Wed', 1),
(51, 2, 6, 'Wed', 2),
(52, 2, 6, 'Wed', 3),
(60, 2, 7, 'Thu', 4),
(61, 2, 7, 'Thu', 5),
(62, 2, 7, 'Thu', 6),
(63, 2, 7, 'Thu', 7),
(57, 2, 8, 'Thu', 1),
(58, 2, 8, 'Thu', 2),
(59, 2, 8, 'Thu', 3),
(67, 2, 9, 'Fri', 4),
(68, 2, 9, 'Fri', 5),
(69, 2, 9, 'Fri', 6),
(70, 2, 9, 'Fri', 7),
(64, 2, 10, 'Fri', 1),
(65, 2, 10, 'Fri', 2),
(66, 2, 10, 'Fri', 3),
(99, 3, 1, 'Fri', 1),
(100, 3, 1, 'Fri', 2),
(101, 3, 1, 'Fri', 3),
(102, 3, 2, 'Fri', 4),
(103, 3, 2, 'Fri', 5),
(104, 3, 2, 'Fri', 6),
(105, 3, 2, 'Fri', 7),
(71, 3, 3, 'Mon', 1),
(72, 3, 3, 'Mon', 2),
(73, 3, 3, 'Mon', 3),
(74, 3, 4, 'Mon', 4),
(75, 3, 4, 'Mon', 5),
(76, 3, 4, 'Mon', 6),
(77, 3, 4, 'Mon', 7),
(78, 3, 5, 'Tue', 1),
(79, 3, 5, 'Tue', 2),
(80, 3, 5, 'Tue', 3),
(81, 3, 6, 'Tue', 4),
(82, 3, 6, 'Tue', 5),
(83, 3, 6, 'Tue', 6),
(84, 3, 6, 'Tue', 7),
(85, 3, 7, 'Wed', 1),
(86, 3, 7, 'Wed', 2),
(87, 3, 7, 'Wed', 3),
(88, 3, 8, 'Wed', 4),
(89, 3, 8, 'Wed', 5),
(90, 3, 8, 'Wed', 6),
(91, 3, 8, 'Wed', 7),
(92, 3, 9, 'Thu', 1),
(93, 3, 9, 'Thu', 2),
(94, 3, 9, 'Thu', 3),
(95, 3, 10, 'Thu', 4),
(96, 3, 10, 'Thu', 5),
(97, 3, 10, 'Thu', 6),
(98, 3, 10, 'Thu', 7),
(137, 4, 1, 'Fri', 4),
(138, 4, 1, 'Fri', 5),
(139, 4, 1, 'Fri', 6),
(140, 4, 1, 'Fri', 7),
(134, 4, 2, 'Fri', 1),
(135, 4, 2, 'Fri', 2),
(136, 4, 2, 'Fri', 3),
(109, 4, 3, 'Mon', 4),
(110, 4, 3, 'Mon', 5),
(111, 4, 3, 'Mon', 6),
(112, 4, 3, 'Mon', 7),
(106, 4, 4, 'Mon', 1),
(107, 4, 4, 'Mon', 2),
(108, 4, 4, 'Mon', 3),
(116, 4, 5, 'Tue', 4),
(117, 4, 5, 'Tue', 5),
(118, 4, 5, 'Tue', 6),
(119, 4, 5, 'Tue', 7),
(113, 4, 6, 'Tue', 1),
(114, 4, 6, 'Tue', 2),
(115, 4, 6, 'Tue', 3),
(123, 4, 7, 'Wed', 4),
(124, 4, 7, 'Wed', 5),
(125, 4, 7, 'Wed', 6),
(126, 4, 7, 'Wed', 7),
(120, 4, 8, 'Wed', 1),
(121, 4, 8, 'Wed', 2),
(122, 4, 8, 'Wed', 3),
(130, 4, 9, 'Thu', 4),
(131, 4, 9, 'Thu', 5),
(132, 4, 9, 'Thu', 6),
(133, 4, 9, 'Thu', 7),
(127, 4, 10, 'Thu', 1),
(128, 4, 10, 'Thu', 2),
(129, 4, 10, 'Thu', 3),
(162, 5, 1, 'Thu', 1),
(163, 5, 1, 'Thu', 2),
(164, 5, 1, 'Thu', 3),
(165, 5, 2, 'Thu', 4),
(166, 5, 2, 'Thu', 5),
(167, 5, 2, 'Thu', 6),
(168, 5, 2, 'Thu', 7),
(169, 5, 3, 'Fri', 1),
(170, 5, 3, 'Fri', 2),
(171, 5, 3, 'Fri', 3),
(172, 5, 4, 'Fri', 4),
(173, 5, 4, 'Fri', 5),
(174, 5, 4, 'Fri', 6),
(175, 5, 4, 'Fri', 7),
(141, 5, 5, 'Mon', 1),
(142, 5, 5, 'Mon', 2),
(143, 5, 5, 'Mon', 3),
(144, 5, 6, 'Mon', 4),
(145, 5, 6, 'Mon', 5),
(146, 5, 6, 'Mon', 6),
(147, 5, 6, 'Mon', 7),
(148, 5, 7, 'Tue', 1),
(149, 5, 7, 'Tue', 2),
(150, 5, 7, 'Tue', 3),
(151, 5, 8, 'Tue', 4),
(152, 5, 8, 'Tue', 5),
(153, 5, 8, 'Tue', 6),
(154, 5, 8, 'Tue', 7),
(155, 5, 9, 'Wed', 1),
(156, 5, 9, 'Wed', 2),
(157, 5, 9, 'Wed', 3),
(158, 5, 10, 'Wed', 4),
(159, 5, 10, 'Wed', 5),
(160, 5, 10, 'Wed', 6),
(161, 5, 10, 'Wed', 7);

-- --------------------------------------------------------

--
-- Table structure for table `contact_us`
--

CREATE TABLE `contact_us` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dentists`
--

CREATE TABLE `dentists` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `image_url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dentists`
--

INSERT INTO `dentists` (`id`, `first_name`, `last_name`, `gender`, `phone`, `email_address`, `image_url`) VALUES
(1, 'William', 'Lam', 'M', '12345678', 'william.lam@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/william.jpg'),
(2, 'Emily', 'Wong', 'F', '23456789', 'emily.wong@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/emily.jpg'),
(3, 'David', 'Cheung', 'M', '34567890', 'david.cheung@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/david.jpg'),
(4, 'Sophie', 'Li', 'F', '45678901', 'sophie.li@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/sophie.jpg'),
(5, 'Michael', 'Ng', 'M', '56789012', 'michael.ng@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/michael.jpg'),
(6, 'Grace', 'Chan', 'F', '67890123', 'grace.chan@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/grace.jpg'),
(7, 'Thomas', 'Ho', 'M', '78901234', 'thomas.ho@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/thomas.jpg'),
(8, 'Rachel', 'Lau', 'F', '89012345', 'rachel.lau@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/rachel.jpg'),
(9, 'James', 'Yip', 'M', '90123456', 'james.yip@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/james.jpg'),
(10, 'Linda', 'Tsang', 'F', '91234567', 'linda.tsang@clinic.com', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dentists/linda.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `dentist_items`
--

CREATE TABLE `dentist_items` (
  `id` int(11) NOT NULL,
  `dentist_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `fee` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dentist_items`
--

INSERT INTO `dentist_items` (`id`, `dentist_id`, `item_id`, `fee`) VALUES
(1, 1, 1, 200.00),
(2, 1, 2, 300.00),
(3, 1, 5, 150.00),
(4, 2, 1, 250.00),
(5, 2, 3, 400.00),
(6, 2, 5, 180.00),
(7, 3, 2, 350.00),
(8, 3, 3, 500.00),
(9, 3, 4, 1000.00),
(10, 4, 1, 180.00),
(11, 4, 2, 280.00),
(12, 4, 5, 120.00),
(13, 5, 3, 450.00),
(14, 5, 4, 1100.00),
(15, 5, 5, 160.00),
(16, 6, 1, 220.00),
(17, 6, 2, 320.00),
(18, 6, 3, 480.00),
(19, 6, 5, 140.00),
(20, 7, 3, 550.00),
(21, 7, 4, 1200.00),
(22, 8, 1, 270.00),
(23, 8, 2, 340.00),
(24, 8, 5, 170.00),
(25, 9, 1, 230.00),
(26, 9, 3, 520.00),
(27, 9, 4, 1050.00),
(28, 9, 5, 190.00),
(29, 10, 2, 360.00),
(30, 10, 3, 580.00),
(31, 10, 4, 1150.00),
(32, 10, 5, 200.00);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image_url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `image_url`) VALUES
(1, 'Teeth Cleaning', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/teeth_cleaning.jpg'),
(2, 'Tooth Filling', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/tooth_filling.jpg'),
(3, 'Tooth Extraction', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/tooth_extraction.jpg'),
(4, 'Root Canal Treatment', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/root_canal_treatment.jpg'),
(5, 'Dental Checkup', 'https://poly-sehs4701-groupproject-s3.s3.ap-east-1.amazonaws.com/dental_checkup.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `last_login_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `timeslots`
--

CREATE TABLE `timeslots` (
  `id` int(11) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `timeslots`
--

INSERT INTO `timeslots` (`id`, `start_time`, `end_time`) VALUES
(1, '09:00:00', '10:00:00'),
(2, '10:00:00', '11:00:00'),
(3, '11:00:00', '12:00:00'),
(4, '14:00:00', '15:00:00'),
(5, '15:00:00', '16:00:00'),
(6, '16:00:00', '17:00:00'),
(7, '17:00:00', '18:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_PATIENT` (`patient_id`),
  ADD KEY `FK_CLINIC_DENTIST` (`clinic_dentist_id`),
  ADD KEY `idx_appointments` (`appointment_date`);

--
-- Indexes for table `appointment_items`
--
ALTER TABLE `appointment_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_APPOINTMENT` (`appointment_id`),
  ADD KEY `FK_DENTIST_ITEM` (`dentist_item_id`);

--
-- Indexes for table `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clinics`
--
ALTER TABLE `clinics`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clinic_dentists`
--
ALTER TABLE `clinic_dentists`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique` (`clinic_id`,`dentist_id`,`day_of_week`,`time_slot_id`),
  ADD KEY `FK_DENTIST_1` (`dentist_id`),
  ADD KEY `FK_TIMESLOT_1` (`time_slot_id`);

--
-- Indexes for table `contact_us`
--
ALTER TABLE `contact_us`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dentists`
--
ALTER TABLE `dentists`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dentist_items`
--
ALTER TABLE `dentist_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_DENTIST_2` (`dentist_id`),
  ADD KEY `FK_ITEM_1` (`item_id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `timeslots`
--
ALTER TABLE `timeslots`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `appointment_items`
--
ALTER TABLE `appointment_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clinics`
--
ALTER TABLE `clinics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `clinic_dentists`
--
ALTER TABLE `clinic_dentists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=176;

--
-- AUTO_INCREMENT for table `contact_us`
--
ALTER TABLE `contact_us`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dentists`
--
ALTER TABLE `dentists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `dentist_items`
--
ALTER TABLE `dentist_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `timeslots`
--
ALTER TABLE `timeslots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `FK_CLINIC_DENTIST` FOREIGN KEY (`clinic_dentist_id`) REFERENCES `clinic_dentists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PATIENT` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `appointment_items`
--
ALTER TABLE `appointment_items`
  ADD CONSTRAINT `FK_APPOINTMENT` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DENTIST_ITEM` FOREIGN KEY (`dentist_item_id`) REFERENCES `dentist_items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `clinic_dentists`
--
ALTER TABLE `clinic_dentists`
  ADD CONSTRAINT `FK_CLINIC_1` FOREIGN KEY (`clinic_id`) REFERENCES `clinics` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DENTIST_1` FOREIGN KEY (`dentist_id`) REFERENCES `dentists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TIMESLOT_1` FOREIGN KEY (`time_slot_id`) REFERENCES `timeslots` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dentist_items`
--
ALTER TABLE `dentist_items`
  ADD CONSTRAINT `FK_DENTIST_2` FOREIGN KEY (`dentist_id`) REFERENCES `dentists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ITEM_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
