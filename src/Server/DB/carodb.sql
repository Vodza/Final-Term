CREATE DATABASE IF NOT EXISTS `carodb` 
USE `carodb`;

-- Dumping structure for table carodb.gamematch
CREATE TABLE IF NOT EXISTS `gamematch` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PlayerID1` int(11) NOT NULL,
  `PlayerID2` int(11) NOT NULL,
  `WinnerID` int(11) DEFAULT NULL,
  `PlayTime` int(11) NOT NULL,
  `TotalMove` int(11) NOT NULL,
  `StartedTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Chat` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table carodb.gamematch:

REPLACE INTO `gamematch` (`ID`, `PlayerID1`, `PlayerID2`, `WinnerID`, `PlayTime`, `TotalMove`, `StartedTime`, `Chat`) VALUES
	(?, ?, ?, ?, ?, ?, ?, NULL);


-- Dumping structure for table carodb.player
CREATE TABLE IF NOT EXISTS `player` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Nam',
  `YearOfBirth` int(4) NOT NULL DEFAULT 2000,
  `Score` int(11) NOT NULL DEFAULT 0,
  `MatchCount` int(11) NOT NULL DEFAULT 0,
  `WinCount` int(11) NOT NULL DEFAULT 0,
  `LoseCount` int(11) NOT NULL DEFAULT 0,
  `CurrentStreak` int(11) NOT NULL DEFAULT 0,
  `Rank` int(11) NOT NULL DEFAULT -1,
  `Blocked` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNIQUE` (`Email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table carodb.player: ~10 rows (approximately)

REPLACE INTO `player` (`ID`, `Email`, `Password`, `Avatar`, `Name`, `Gender`, `YearOfBirth`, `Score`, `MatchCount`, `WinCount`, `LoseCount`, `CurrentStreak`, `Rank`, `Blocked`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);


