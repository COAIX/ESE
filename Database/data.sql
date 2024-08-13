/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : health_g

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 15/07/2024 02:24:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `appointmentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `primaryPhysician` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `schedule` timestamp NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`appointmentId`) USING BTREE,
  INDEX `userId`(`userId` ASC) USING BTREE,
  INDEX `patient`(`patient` ASC) USING BTREE,
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('66902aec0038a80c7c88', '669024280028054979f4', '669024c90003946c25c7', 'David Livingston', 'Annual montly check-up', '2024-07-16 02:56:30', 'scheduled', 'Preferafternoonappointments,ifpossible');
INSERT INTO `appointment` VALUES ('66902c400009c77df807', '669024280028054979f4', '669024c90003946c25c7', 'David Livingston', 'Annual montly check-up', '2024-07-12 03:02:10', 'pending', 'Annual montly check-up');
INSERT INTO `appointment` VALUES ('66902cc1002c8b05afca', '66902c5b0012d4a415ca', '66902cad0019c2368558', 'Jane Powell', 'Annual montly check-up', '2024-07-12 03:04:14', 'pending', 'Preferafternoonappointments,ifpossible');
INSERT INTO `appointment` VALUES ('66903989000b16ecfac7', '66902c5b0012d4a415ca', '66902cad0019c2368558', 'Jasmine Lee', 'Annual montly check-up', '2024-07-12 04:30:00', 'pending', 'Preferafternoonappointments,ifpossible');
INSERT INTO `appointment` VALUES ('66903afd00113fabc013', '66902c5b0012d4a415ca', '66902cad0019c2368558', 'David Livingston', 'Annual montly check-up', '2024-07-12 04:05:08', 'pending', 'Preferafternoonappointments,ifpossible');
INSERT INTO `appointment` VALUES ('66903b420003db9d98a9', '66903b27000dc5eebb6b', '66903b3a0011ed382776', 'Evan Peter', 'Annual montly check-up', '2024-07-12 04:06:18', 'pending', 'Preferafternoon appointments,if possible');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `patientId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthDate` timestamp NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `occupation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emergencyContactName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emergencyContactNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `primaryPhysician` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `insuranceProvider` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `insurancePolicyNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `allergies` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `currentMedication` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `familyMedicalHistory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `pastMedicalHistory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `privacyConsent` tinyint(1) NOT NULL,
  PRIMARY KEY (`patientId`) USING BTREE,
  INDEX `userId`(`userId` ASC) USING BTREE,
  CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('669024c90003946c25c7', '669024280028054979f4', 'doe', 'doe@gmail.com', '+441111111111', '2024-07-12 02:25:13', 'Male', '14 street, New york, NY - 5101', 'ABC123456789', 'ABC123456789', '+44111111111', 'Alyana Cruz', 'ABC123456789', 'ABC123456789', 'ABC123456789', 'ABC123456789', 'ABC123456789', 'ABC123456789', 1);
INSERT INTO `patient` VALUES ('66902cad0019c2368558', '66902c5b0012d4a415ca', 'boe', 'boe@gmail.com', '+44222222222', '2024-07-12 03:03:28', 'Male', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '+44111111111', 'Alyana Cruz', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', 1);
INSERT INTO `patient` VALUES ('66903b3a0011ed382776', '66903b27000dc5eebb6b', 'coe', 'coe@gmail.com', '+44333333333', '2024-07-12 04:05:08', 'Male', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '+44333333333', 'Alyana Cruz', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', '14 street, New york, NY - 5101', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE,
  UNIQUE INDEX `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('669024280028054979f4', 'doe@gmail.com', '+441111111111', 'doe');
INSERT INTO `user` VALUES ('66902c5b0012d4a415ca', 'boe@gmail.com', '+44222222222', 'boe');
INSERT INTO `user` VALUES ('66903b27000dc5eebb6b', 'coe@gmail.com', '+44333333333', 'coe');
INSERT INTO `user` VALUES ('66903b510000d8e35a38', 'voe@gmail.com', '+44555555555', 'voe');

SET FOREIGN_KEY_CHECKS = 1;
