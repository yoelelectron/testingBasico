CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    director VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL
);

insert into movies (name, minutes,director, genre) values
('Dark Knight', 152,'PEPITO','ACTION'),
('STAR WARS: The empire strikes back', 258,'GEORGE LUCAS', 'THRILLER'),
('STAR WARS: The return of the Jedi', 258,'GEORGE LUCAS', 'THRILLER'),
('STAR WARS: a new hope', 258,'GEORGE LUCAS', 'THRILLER'),
('Matrix', 182,'PEPITO', 'ACTION');