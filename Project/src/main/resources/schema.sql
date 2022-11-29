CREATE TABLE director (
    directorId int AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(255),
    lastName varchar(255),
    isActive int
);


CREATE TABLE movie (
    movieId int AUTO_INCREMENT PRIMARY KEY,
    movieTitle varchar(255),
    movieYearReleased int,
    movieTakings int,
    movieDirectorID int
);