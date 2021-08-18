-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 18, 2021 at 07:41 AM
-- Server version: 10.3.30-MariaDB-cll-lve
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minevers_RPL`
--

-- --------------------------------------------------------

--
-- Table structure for table `absen`
--

CREATE TABLE `absen` (
  `NIP` varchar(255) NOT NULL,
  `nama_shift` varchar(255) NOT NULL,
  `tanggal` date NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL,
  `total_lembur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absen`
--

INSERT INTO `absen` (`NIP`, `nama_shift`, `tanggal`, `jam_masuk`, `jam_keluar`, `total_lembur`) VALUES
('196105261994031001', 'Shift Pagi', '2020-12-01', '06:55:00', '16:00:00', 1),
('196509151995031001', 'Shift Sore', '2020-12-01', '15:05:00', '23:00:00', 0),
('196807031996032001', 'Shift Malam', '2020-12-01', '23:10:00', '08:00:00', 1),
('196901011996032001', 'Shift Pagi', '2020-12-01', '07:09:00', '15:00:00', 0),
('196907062000031002', 'Shift Sore', '2020-12-01', '15:08:00', '01:00:00', 2),
('197007061997031002', 'Shift Malam', '2020-12-02', '23:03:00', '07:00:00', 0),
('197010012000031002', 'Shift Pagi', '2020-12-03', '06:50:00', '17:00:00', 2),
('197304102005011004', 'Shift Sore', '2020-12-02', '14:58:00', '24:00:00', 1),
('197412312005012004', 'Shift Malam', '2020-12-02', '23:04:00', '09:00:00', 2),
('198203022005011002', 'Shift Pagi', '2020-12-02', '06:57:00', '15:00:00', 0),
('196105261994031001', 'Shift Sore', '2020-12-02', '14:59:00', '01:00:00', 2),
('196509151995031001', 'Shift Malam', '2020-12-03', '22:55:00', '07:00:00', 0),
('196807031996032001', 'Shift Pagi', '2020-12-03', '07:00:00', '16:00:00', 1),
('196901011996032001', 'Shift Sore', '2020-12-03', '15:02:00', '23:00:00', 0),
('196907062000031002', 'Shift Malam', '2020-12-03', '23:01:00', '09:00:00', 2),
('197007061997031002', 'Shift Pagi', '2020-12-04', '07:05:00', '16:00:00', 1),
('197010012000031002', 'Shift Sore', '2020-12-04', '14:59:00', '23:00:00', 0),
('197304102005011004', 'Shift Malam', '2020-12-04', '23:06:00', '09:00:00', 2),
('197412312005012004', 'Shift Pagi', '2020-12-04', '06:54:00', '17:00:00', 2),
('198203022005011002', 'Shift Sore', '2020-12-04', '15:07:00', '00:00:00', 1),
('196105261994031001', 'Shift Malam', '2020-12-07', '23:01:00', '07:00:00', 0),
('196509151995031001', 'Shift Pagi', '2020-12-07', '06:55:00', '16:00:00', 1),
('196807031996032001', 'Shift Sore', '2020-12-07', '14:53:00', '01:00:00', 2),
('196901011996032001', 'Shift Malam', '2020-12-07', '23:06:00', '07:00:00', 0),
('196907062000031002', 'Shift Pagi', '2020-12-07', '07:08:00', '17:00:00', 2),
('197007061997031002', 'Shift Sore', '2020-12-08', '15:00:00', '00:00:00', 1),
('197010012000031002', 'Shift Malam', '2020-12-08', '23:09:00', '07:00:00', 0),
('197304102005011004', 'Shift Pagi', '2020-12-08', '07:04:00', '15:00:00', 0),
('197412312005012004', 'Shift Sore', '2020-12-08', '15:10:00', '00:00:00', 1),
('198203022005011002', 'Shift Malam', '2020-12-08', '22:58:00', '09:00:00', 2),
('196105261994031001', 'Shift Pagi', '2020-12-09', '07:02:00', '15:00:00', 0),
('196509151995031001', 'Shift Sore', '2020-12-09', '15:05:00', '01:00:00', 2),
('196807031996032001', 'Shift Malam', '2020-12-09', '23:01:00', '08:00:00', 1),
('196901011996032001', 'Shift Pagi', '2020-12-09', '07:07:00', '15:00:00', 0),
('196907062000031002', 'Shift Sore', '2020-12-09', '15:04:00', '00:00:00', 1),
('197007061997031002', 'Shift Malam', '2020-12-10', '23:09:00', '07:00:00', 0),
('197010012000031002', 'Shift Pagi', '2020-12-10', '07:05:00', '16:00:00', 1),
('197304102005011004', 'Shift Sore', '2020-12-10', '14:52:00', '23:00:00', 0),
('197412312005012004', 'Shift Malam', '2020-12-10', '23:10:00', '08:00:00', 1),
('198203022005011002', 'Shift Pagi', '2020-12-10', '07:01:00', '15:00:00', 0),
('196105261994031001', 'Shift Sore', '2020-12-11', '15:00:00', '24:00:00', 1),
('196509151995031001', 'Shift Malam', '2020-12-11', '23:08:00', '07:00:00', 0),
('196807031996032001', 'Shift Pagi', '2020-12-11', '06:58:00', '16:00:00', 1),
('196901011996032001', 'Shift Sore', '2020-12-11', '15:08:00', '01:00:00', 2),
('196907062000031002', 'Shift Malam', '2020-12-11', '22:59:00', '08:00:00', 1),
('197007061997031002', 'Shift Pagi', '2020-12-14', '06:50:00', '15:00:00', 0),
('197010012000031002', 'Shift Sore', '2020-12-14', '15:05:00', '00:00:00', 1),
('197304102005011004', 'Shift Malam', '2020-12-14', '23:08:00', '08:08:00', 1),
('197412312005012004', 'Shift Pagi', '2020-12-14', '06:58:00', '15:08:00', 0),
('198203022005011002', 'Shift Sore', '2020-12-14', '15:08:00', '23:10:00', 0),
('196105261994031001', 'Shift Malam', '2020-12-15', '23:00:00', '09:00:00', 2),
('196509151995031001', 'Shift Pagi', '2020-12-15', '07:05:00', '16:10:00', 1),
('196807031996032001', 'Shift Sore', '2020-12-15', '15:00:00', '01:00:00', 2),
('196901011996032001', 'Shift Malam', '2020-12-15', '22:50:00', '07:00:00', 0),
('196907062000031002', 'Shift Pagi', '2020-12-15', '07:05:00', '16:07:00', 1),
('197007061997031002', 'Shift Sore', '2020-12-16', '14:50:00', '23:00:00', 0),
('197010012000031002', 'Shift Malam', '2020-12-16', '22:58:00', '07:04:00', 0),
('197304102005011004', 'Shift Pagi', '2020-12-16', '06:57:00', '16:03:00', 1),
('197412312005012004', 'Shift Sore', '2020-12-16', '14:55:00', '00:05:00', 1),
('198203022005011002', 'Shift Malam', '2020-12-16', '23:00:00', '08:00:00', 1),
('196105261994031001', 'Shift Pagi', '2020-12-17', '07:00:00', '17:00:00', 2),
('196509151995031001', 'Shift Sore', '2020-12-17', '15:05:00', '23:05:00', 0),
('196807031996032001', 'Shift Malam', '2020-12-17', '23:01:00', '07:01:00', 0),
('196901011996032001', 'Shift Pagi', '2020-12-17', '06:59:00', '17:00:00', 2),
('196907062000031002', 'Shift Sore', '2020-12-17', '14:55:00', '23:05:00', 0),
('197007061997031002', 'Shift Malam', '2020-12-18', '23:00:00', '08:00:00', 1),
('197010012000031002', 'Shift Pagi', '2020-12-18', '06:55:00', '15:00:00', 0),
('197304102005011004', 'Shift Sore', '2020-12-18', '15:05:00', '00:05:00', 1),
('197412312005012004', 'Shift Malam', '2020-12-18', '22:55:00', '08:05:00', 1),
('198203022005011002', 'Shift Pagi', '2020-12-18', '07:01:00', '16:10:00', 1),
('196105261994031001', 'Shift Sore', '2020-12-21', '14:55:00', '23:05:00', 0),
('196509151995031001', 'Shift Malam', '2020-12-21', '23:05:00', '08:10:00', 1),
('196807031996032001', 'Shift Pagi', '2020-12-21', '07:00:00', '15:00:00', 0),
('196901011996032001', 'Shift Sore', '2020-12-21', '15:00:00', '23:01:00', 0),
('196907062000031002', 'Shift Malam', '2020-12-21', '23:00:00', '08:10:00', 1),
('197007061997031002', 'Shift Pagi', '2020-12-22', '06:59:00', '15:00:00', 0),
('197010012000031002', 'Shift Sore', '2020-12-22', '15:01:00', '00:05:00', 1),
('197304102005011004', 'Shift Malam', '2020-12-22', '23:05:00', '07:05:00', 0),
('197412312005012004', 'Shift Pagi', '2020-12-22', '06:55:00', '17:05:00', 2),
('198203022005011002', 'Shift Sore', '2020-12-22', '15:08:00', '23:10:00', 0),
('196105261994031001', 'Shift Malam', '2020-12-23', '23:00:00', '08:00:00', 1),
('196509151995031001', 'Shift Pagi', '2020-12-23', '06:50:00', '16:00:00', 1),
('196807031996032001', 'Shift Sore', '2020-12-23', '15:00:00', '23:00:00', 0),
('196901011996032001', 'Shift Malam', '2020-12-23', '23:00:00', '07:05:00', 0),
('196907062000031002', 'Shift Pagi', '2020-12-23', '07:00:00', '16:00:00', 1),
('admin', 'Shift Pagi', '2021-01-01', '07:09:00', '16:00:00', 1),
('196105261994031001', 'Shift Pagi', '2021-01-01', '07:01:00', '16:00:00', 1),
('197304102005011004', 'Shift Sore', '2021-01-01', '15:01:00', '02:00:00', 3),
('admin', 'Shift Sore', '2021-01-02', '15:00:00', '01:00:00', 2),
('196509151995031001', 'Shift Sore', '2021-01-02', '15:01:00', '01:03:00', 2),
('196807031996032001', 'Shift Malam', '2021-01-02', '22:50:00', '09:05:00', 2),
('196105261994031001', 'Shift Pagi', '2021-01-05', '07:08:00', '16:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `golongan`
--

CREATE TABLE `golongan` (
  `jenis_golongan` varchar(255) NOT NULL,
  `gaji_pokok` double NOT NULL,
  `gaji_lembur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `golongan`
--

INSERT INTO `golongan` (`jenis_golongan`, `gaji_pokok`, `gaji_lembur`) VALUES
('Manajer', 200000, 10000),
('Pegawai', 150000, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `golongan_pegawai`
--

CREATE TABLE `golongan_pegawai` (
  `NIP` varchar(255) NOT NULL,
  `jenis_golongan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `golongan_pegawai`
--

INSERT INTO `golongan_pegawai` (`NIP`, `jenis_golongan`) VALUES
('admin', 'Manajer'),
('196105261994031001', 'Pegawai'),
('196509151995031001', 'Manajer'),
('196807031996032001', 'Pegawai'),
('196901011996032001', 'Pegawai'),
('196907062000031002', 'Pegawai'),
('197007061997031002', 'Manajer'),
('197010012000031002', 'Pegawai'),
('197304102005011004', 'Pegawai'),
('197412312005012004', 'Pegawai'),
('198203022005011002', 'Pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `NIP` varchar(255) NOT NULL,
  `Nama` varchar(255) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `Biodata` text NOT NULL,
  `Password` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`NIP`, `Nama`, `tgl_lahir`, `Biodata`, `Password`, `admin`) VALUES
('196105261994031001', 'M Banta', '1961-06-25', 'Tempat Lahir: Bale', '5f4dcc3b5aa765d61d8327deb882cf99', 0),
('196509151995031001', 'M Nur Rasyid', '1965-05-19', 'Tempat Lahir: Rheum Timu', '7c6a180b36896a0a8c02787eeafb0e4c', 0),
('196807031996032001', 'Suraiya', '1968-07-03', 'Tempat Lahir: Hagu', '6cb75f652a9b52798eb6cf2201057c73', 0),
('196901011996032001', 'Umi Kalsum', '1969-01-01', 'Tempat Lahir: Garang', '819b0643d6b89dc9b579fdfc9094f28e', 0),
('196907062000031002', 'Hamdani', '1969-07-06', 'Tempat Lahir: Jeumpo', '34cc93ece0ba9e3f6f235d4af979b16c', 0),
('197007061997031002', 'Sulaiman', '1970-07-06', 'Tempat Lahir: Pante Raya', 'db0edd04aaac4506f7edab03ac855d56', 0),
('197010012000031002', 'Darmawan', '1970-10-01', 'Tempat Lahir: Kulu Kuta', '218dd27aebeccecae69ad8408d9a36bf', 0),
('197304102005011004', 'Andi Ahmad', '1973-04-10', 'Tempat Lahir: Ujong', '00cdb7bb942cf6b290ceb97d6aca64a3', 0),
('197412312005012004', 'Basyariah Ahmad', '1974-12-31', 'Tempat Lahir: Namploh', 'b25ef06be3b6948c0bc431da46c2c738', 0),
('198203022005011002', 'Yasmar Aji', '1982-03-02', 'Tempat Lahir: Ulee Tanoh', '5d69dd95ac183c9643780ed7027d128a', 0),
('admin', 'admin', '2000-01-01', 'Admin Session', '21232f297a57a5a743894a0e4a801fc3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Shift`
--

CREATE TABLE `Shift` (
  `Nama_shift` varchar(255) NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Shift`
--

INSERT INTO `Shift` (`Nama_shift`, `jam_masuk`, `jam_keluar`) VALUES
('Shift Malam', '23:00:00', '07:00:00'),
('Shift Pagi', '07:00:00', '15:00:00'),
('Shift Sore', '15:00:00', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `shift_pegawai`
--

CREATE TABLE `shift_pegawai` (
  `NIP` varchar(255) NOT NULL,
  `Nama_Shift` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shift_pegawai`
--

INSERT INTO `shift_pegawai` (`NIP`, `Nama_Shift`) VALUES
('admin', 'Shift Pagi'),
('196105261994031001', 'Shift Malam'),
('196509151995031001', 'Shift Sore'),
('196807031996032001', 'Shift Malam'),
('196901011996032001', 'Shift Pagi'),
('196907062000031002', 'Shift Sore'),
('197007061997031002', 'Shift Malam'),
('197010012000031002', 'Shift Malam'),
('197304102005011004', 'Shift Sore'),
('197412312005012004', 'Shift Malam'),
('198203022005011002', 'Shift Pagi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absen`
--
ALTER TABLE `absen`
  ADD KEY `fk_absen_pegawai` (`NIP`),
  ADD KEY `fk_absen_shift` (`nama_shift`);

--
-- Indexes for table `golongan`
--
ALTER TABLE `golongan`
  ADD PRIMARY KEY (`jenis_golongan`);

--
-- Indexes for table `golongan_pegawai`
--
ALTER TABLE `golongan_pegawai`
  ADD KEY `fk_golongan_pegawai` (`jenis_golongan`),
  ADD KEY `fk_pegawai_golongan` (`NIP`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`NIP`);

--
-- Indexes for table `Shift`
--
ALTER TABLE `Shift`
  ADD PRIMARY KEY (`Nama_shift`);

--
-- Indexes for table `shift_pegawai`
--
ALTER TABLE `shift_pegawai`
  ADD KEY `fk_shift_pegawai` (`Nama_Shift`),
  ADD KEY `fk_pegawai_shift` (`NIP`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absen`
--
ALTER TABLE `absen`
  ADD CONSTRAINT `fk_absen_pegawai` FOREIGN KEY (`NIP`) REFERENCES `pegawai` (`NIP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_absen_shift` FOREIGN KEY (`nama_shift`) REFERENCES `Shift` (`Nama_shift`);

--
-- Constraints for table `golongan_pegawai`
--
ALTER TABLE `golongan_pegawai`
  ADD CONSTRAINT `fk_golongan_pegawai` FOREIGN KEY (`jenis_golongan`) REFERENCES `golongan` (`jenis_golongan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pegawai_golongan` FOREIGN KEY (`NIP`) REFERENCES `pegawai` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shift_pegawai`
--
ALTER TABLE `shift_pegawai`
  ADD CONSTRAINT `fk_pegawai_shift` FOREIGN KEY (`NIP`) REFERENCES `pegawai` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_shift_pegawai` FOREIGN KEY (`Nama_Shift`) REFERENCES `Shift` (`Nama_shift`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
