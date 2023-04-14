insert into Airline (name) values('Lufthansa');

insert into Flight (FlightNum,departure,arrival,airline) values ('F123','Madrid','Barcelona',1);
insert into Flight (FlightNum,Departure,arrival,airline) values('F234','Keflavík','Berlín',1);
insert into Flight (FlightNum,Departure,arrival,airline) values('F432','Berlin','Keflavík',1);

insert into DateFlight(flight,Total_Seats,seats_left) values(2,30,30);
insert into DateFlight(flight,Total_Seats,seats_left) values(3,30,30);
insert into DateFlight(flight,Total_Seats,seats_left) values(1,20,20);

insert into Customer(name,ssn,email) values ('Flón Jón',1234567890,'flon@jon.is');
insert into Customer(name,ssn,email) values ('Dana Banana',1230992200,'manana@man.is');

insert into bookings(bookingId,customer,flight,seats) values ('ARG1233',1,2,1);
insert into bookings(bookingId,customer,flight,seats) values ('MAM3333',2,3,2);

insert into ticket(booking,name,SeatAssigned) values(1,'Jón',true);
insert into ticket (booking,name,SeatAssigned) values(2,'Dana',true);

insert into seats(flight,ticket,seat) values(2,1,'A4');
insert into seats(flight,ticket,seat) values(3,2,'B2');
