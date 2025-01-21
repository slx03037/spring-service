CREATE TABLE `student` (
                           `id` bigint NOT NULL,
                           `name` varchar(32) DEFAULT NULL,
                           `age` int DEFAULT NULL,
                           `score` decimal(5,2) DEFAULT NULL,
                           `class` int DEFAULT NULL,
                           `grade` int DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;