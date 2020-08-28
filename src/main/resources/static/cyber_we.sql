-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Час створення: Сер 26 2020 р., 16:58
-- Версія сервера: 5.7.24
-- Версія PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `cyber_we`
--

-- --------------------------------------------------------

--
-- Структура таблиці `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `text` text,
  `author` varchar(45) DEFAULT NULL,
  `link` varchar(45) DEFAULT NULL,
  `rating` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `reviews`
--

INSERT INTO `reviews` (`id`, `title`, `text`, `author`, `link`, `rating`) VALUES
(1, 'Civilization IV news', 'Civilization IV presents new super addons', 'Vasya Pupkin', 'http:\\cyberweserverarticlesarticle1', 3);

-- --------------------------------------------------------

--
-- Структура таблиці `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_AUTHOR'),
(4, 'ROLE_MODERATOR');

-- --------------------------------------------------------

--
-- Структура таблиці `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `users`
--

INSERT INTO `users` (`id`, `city`, `country`, `email`, `first_name`, `last_name`, `username`, `password`, `gender`, `date_of_birth`) VALUES
(1, 'LA', 'USA', 'user@gmail.com', 'abc', 'def', 'user', '$2a$10$IyWtEgH5ACHgputfnhTdReOjS7h9qpA7.sSBPcpjEttIevsGp8Adu', 'M', '2019-01-01'),
(2, NULL, NULL, 'admin@gmail.com', NULL, NULL, 'admin', '$2a$10$CFPzvlCjanoQBsPoQNYdL.oRPZpmvXn9s/ZfurGOM5EvQz0nHmgcu', NULL, '2019-01-01'),
(3, NULL, NULL, 'moderator@gmail.com', NULL, NULL, 'moderator', '$2a$10$D82adAEvop8fblEU9D39YuOzvROroF9rx01kByesqTgOgIHuJbvCe', NULL, '2019-01-01'),
(4, NULL, NULL, 'author@gmail.com', NULL, NULL, 'author', '$2a$10$qa5VYbNGXYSncHXqjAEOQ.UsKWFezk4h1ZBwcEEXQ5N1.IDI7tELS', NULL, '2019-01-01');

-- --------------------------------------------------------

--
-- Структура таблиці `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` tinyint(4) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
