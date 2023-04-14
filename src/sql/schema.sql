CREATE TABLE public.Airline(
    id SERIAL PRIMARY KEY,
    name VARCHAR(36) NOT NULL UNIQUE
);
CREATE TABLE public.Flight (
    id serial PRIMARY KEY,
    FlightNum VARCHAR(8) NOT NULL UNIQUE,
    Departure VARCHAR(36) NOT NULL,
    Arrival VARCHAR(36) NOT NULL,
    Airline int NOT NULL,
    length TIME,
    FOREIGN KEY (Airline) references Airline(id)
);
CREATE TABLE public.DateFlight(
    id serial PRIMARY KEY,
    flight int,
    day DATE NOT NULL DEFAULT current_date,
    departing  TIMESTAMP NOT NULL default current_timestamp,
    arriving TIMESTAMP NOT NULL default current_timestamp,
    Total_Seats int NOT NULL ,
    seats_left int DEFAULT 0,
    FOREIGN KEY (flight) references Flight(id),
    CONSTRAINT uq_pair UNIQUE(flight,day)
);
CREATE TABLE public.Customer(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(36) NOT NULL,
    SSN INT NOT NULL UNIQUE,
    email VARCHAR(36)
);
CREATE TABLE public.Bookings(
    id SERIAL PRIMARY KEY,
    bookingId varchar(20) not null UNIQUE,
    customer int,
    flight int NOT NULL,
    seats int DEFAULT 0,
    FOREIGN KEY (flight) references DateFlight(id),
    FOREIGN KEY (customer) references Customer(id)
);
CREATE TABLE public.ticket(
    id SERIAL PRIMARY KEY,
    booking int NOT NULL,
    passport VARCHAR(36),
    name VARCHAR(36),
    SeatAssigned BOOLEAN default FALSE,
    FOREIGN KEY (booking) references Bookings(id)
);
CREATE TABLE public.Seats(
    id SERIAL PRIMARY KEY,
    flight int not null,
    person int not null,
    ticket int not null,
    seat VARCHAR(3),
    CONSTRAINT uq_seat UNIQUE(flight,seat),
    FOREIGN KEY (ticket) references ticket(id)
);
CREATE TABLE public.Extras (
    id SERIAL PRIMARY KEY,
    ticket int not null,
    name VARCHAR(36) not null,
    description VARCHAR(1000),
    price int,
    FOREIGN KEY (ticket) REFERENCES ticket(id)
);