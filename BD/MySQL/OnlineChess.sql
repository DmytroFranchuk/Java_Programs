CREATE TABLE `players` (
  `id` integer PRIMARY KEY,
  `nickname` varchar(64),
  `login` varchar(20),
  `password` varchar(64),
  `email` varchar(64),
  `rating` varchar(12),
  `countWin` integer,
  `countDraws` integer,
  `countLoss` integer,
  `registration_at` timestamp
);

CREATE TABLE `games` (
  `id` integer PRIMARY KEY,
  `player1_id` integer,
  `player2_id` integer,
  `start_at` timestamp,
  `end_at` timestamp
);

CREATE TABLE `moves` (
  `id` integer PRIMARY KEY,
  `game_id` integer,
  `player_id` integer,
  `move_number` integer,
  `move_piece` varchar(14),
  `movies_at` timestamp
);

CREATE TABLE `chat_messages` (
  `id` integer PRIMARY KEY,
  `game_id` integer,
  `player_id` integer,
  `text` varchar(199),
  `create_at` timestamp
);

CREATE TABLE `rating` (
  `id` integer PRIMARY KEY,
  `player_id` integer,
  `value` float,
  `create_at` timestamp
);

CREATE TABLE `tournaments` (
  `id` integer PRIMARY KEY,
  `moves_id` integer,
  `title` integer,
  `text` text,
  `start_at` timestamp,
  `end_at` timestamp
);

ALTER TABLE `moves` ADD FOREIGN KEY (`player_id`) REFERENCES `players` (`id`);

ALTER TABLE `games` ADD FOREIGN KEY (`id`) REFERENCES `players` (`id`);

ALTER TABLE `tournaments` ADD FOREIGN KEY (`id`) REFERENCES `moves` (`id`);

ALTER TABLE `players` ADD FOREIGN KEY (`id`) REFERENCES `chat_messages` (`id`);

ALTER TABLE `players` ADD FOREIGN KEY (`id`) REFERENCES `rating` (`id`);

ALTER TABLE `players` ADD FOREIGN KEY (`id`) REFERENCES `games` (`player1_id`);

ALTER TABLE `players` ADD FOREIGN KEY (`id`) REFERENCES `games` (`player2_id`);

ALTER TABLE `chat_messages` ADD FOREIGN KEY (`game_id`) REFERENCES `games` (`id`);
