-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2018 at 01:42 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `nama` varchar(30) NOT NULL,
  `namaIbu` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `ttl` varchar(50) NOT NULL,
  `usia` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`nama`, `namaIbu`, `alamat`, `ttl`, `usia`) VALUES
('David', 'Ibunya David', 'Sana', '5 Juli 2018', 1),
('Davideaa', 'Ibu Davide', 'Sini', 'Kemaren', 12);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `Nama` varchar(30) NOT NULL,
  `bcg` varchar(10) DEFAULT NULL,
  `polio1` varchar(10) DEFAULT NULL,
  `polio2` varchar(10) DEFAULT NULL,
  `polio3` varchar(10) DEFAULT NULL,
  `polio4` varchar(10) DEFAULT NULL,
  `campak` varchar(10) DEFAULT NULL,
  `tanggalBcg` varchar(30) DEFAULT NULL,
  `tanggalPolio1` varchar(30) DEFAULT NULL,
  `tanggalPolio2` varchar(30) DEFAULT NULL,
  `tanggalPolio3` varchar(30) DEFAULT NULL,
  `tanggalPolio4` varchar(30) DEFAULT NULL,
  `tanggalCampak` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`Nama`, `bcg`, `polio1`, `polio2`, `polio3`, `polio4`, `campak`, `tanggalBcg`, `tanggalPolio1`, `tanggalPolio2`, `tanggalPolio3`, `tanggalPolio4`, `tanggalCampak`) VALUES
('David', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Davideaa', 'Sudah', 'Sudah', '', '', '', '', '1 Juni', '2 Juni', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `statusanak`
--

CREATE TABLE `statusanak` (
  `nama` varchar(30) NOT NULL,
  `vitA` varchar(10) DEFAULT NULL,
  `bcg` varchar(10) DEFAULT NULL,
  `polio1` varchar(10) DEFAULT NULL,
  `polio2` varchar(10) DEFAULT NULL,
  `polio3` varchar(10) DEFAULT NULL,
  `polio4` varchar(10) DEFAULT NULL,
  `campak` varchar(10) DEFAULT NULL,
  `tanggalBcg` varchar(30) DEFAULT NULL,
  `tanggalPolio1` varchar(30) DEFAULT NULL,
  `tanggalPolio2` varchar(30) DEFAULT NULL,
  `tanggalPolio3` varchar(30) DEFAULT NULL,
  `tanggalPolio4` varchar(30) DEFAULT NULL,
  `tanggalCampak` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tinggi`
--

CREATE TABLE `tinggi` (
  `Nama` varchar(30) NOT NULL,
  `Bulan` varchar(20) NOT NULL,
  `Tinggi Badan` int(5) DEFAULT NULL,
  `Vitamin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tinggi`
--

INSERT INTO `tinggi` (`Nama`, `Bulan`, `Tinggi Badan`, `Vitamin`) VALUES
('Davideaa', 'Februari', 12, 'Sudah'),
('Davideaa', 'Januari', 10, 'Sudah'),
('Davideaa', 'Maret', 13, 'Sudah');

-- --------------------------------------------------------

--
-- Table structure for table `tingianak`
--

CREATE TABLE `tingianak` (
  `Nama` varchar(30) NOT NULL,
  `januari` varchar(11) DEFAULT NULL,
  `februari` varchar(11) DEFAULT NULL,
  `maret` varchar(11) DEFAULT NULL,
  `april` varchar(11) DEFAULT NULL,
  `mei` varchar(11) DEFAULT NULL,
  `juni` varchar(11) DEFAULT NULL,
  `juli` varchar(11) DEFAULT NULL,
  `agustus` varchar(11) DEFAULT NULL,
  `september` varchar(11) DEFAULT NULL,
  `oktober` varchar(11) DEFAULT NULL,
  `november` varchar(11) DEFAULT NULL,
  `desember` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin'),
('user', 'user'),
('adimas', 'adimas'),
('ical', 'ganteng'),
('Kushina', '1'),
('Ibuke', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`nama`,`namaIbu`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`Nama`);

--
-- Indexes for table `statusanak`
--
ALTER TABLE `statusanak`
  ADD PRIMARY KEY (`nama`);

--
-- Indexes for table `tinggi`
--
ALTER TABLE `tinggi`
  ADD PRIMARY KEY (`Nama`,`Bulan`);

--
-- Indexes for table `tingianak`
--
ALTER TABLE `tingianak`
  ADD PRIMARY KEY (`Nama`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `status`
--
ALTER TABLE `status`
  ADD CONSTRAINT `status_ibfk_1` FOREIGN KEY (`Nama`) REFERENCES `pasien` (`nama`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `statusanak`
--
ALTER TABLE `statusanak`
  ADD CONSTRAINT `statusanak_ibfk_1` FOREIGN KEY (`nama`) REFERENCES `pasien` (`nama`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tinggi`
--
ALTER TABLE `tinggi`
  ADD CONSTRAINT `tinggi_ibfk_1` FOREIGN KEY (`Nama`) REFERENCES `pasien` (`nama`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tingianak`
--
ALTER TABLE `tingianak`
  ADD CONSTRAINT `tingianak_ibfk_1` FOREIGN KEY (`Nama`) REFERENCES `pasien` (`nama`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
