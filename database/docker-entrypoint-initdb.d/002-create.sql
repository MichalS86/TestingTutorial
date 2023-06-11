\connect tutorialdb;

CREATE TABLE public.paintings (
	id SERIAL PRIMARY KEY,
	name VARCHAR NOT NULL,
	price FLOAT NOT NULL,
	efficiency FLOAT NOT NULL
);