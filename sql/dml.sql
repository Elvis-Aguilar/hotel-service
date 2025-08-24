--------------------------------------------------------------
-- Insert data into the hotel table
--------------------------------------------------------------


INSERT INTO hotel.hotel (name, address, phone)
VALUES ('Hotel Real Colonial', 'Zona 1, Centro Histórico, Ciudad de Guatemala', '22001122');

INSERT INTO hotel.hotel (name, address, phone)
VALUES ('Hotel Vista Hermosa', 'Carretera a El Salvador, Km 12.5, Santa Catarina Pinula', '22887766');

INSERT INTO hotel.hotel (name, address, phone)
VALUES ('Hotel Paraíso del Mar', 'Puerto San José, Escuintla', '44558899');

INSERT INTO hotel.hotel (name, address, phone)
VALUES ('Hotel Montañas Verdes', 'Antigua Guatemala, Sacatepéquez', '33446655');


--------------------------------------------------------------
-- Insert data into the room table
--------------------------------------------------------------
INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('e2de677b-0657-48f9-9063-5cfeca0e4f43', 'AA-01', 350.00, 100.00, 'Habitación individual con cama matrimonial y vista a la ciudad', 2);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('e2de677b-0657-48f9-9063-5cfeca0e4f43', 'AA-02', 400.00, 120.00, 'Habitación doble con dos camas individuales y balcón', 1);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('e2de677b-0657-48f9-9063-5cfeca0e4f43', 'AA-03', 600.00, 150.00, 'Suite junior con sala pequeña y escritorio de trabajo', 3);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('e2de677b-0657-48f9-9063-5cfeca0e4f43', 'AA-04', 850.00, 200.00, 'Suite ejecutiva con cama king y área de estar amplia', 4);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('e2de677b-0657-48f9-9063-5cfeca0e4f43', 'AB-01', 300.00, 90.00, 'Habitación sencilla con cama individual y escritorio', 5);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('73769a0b-d8a5-4bd8-8e6a-c90b292aab54', 'AB-02', 450.00, 110.00, 'Habitación doble con dos camas queen y televisión smart', 1);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('73769a0b-d8a5-4bd8-8e6a-c90b292aab54', 'AB-03', 700.00, 160.00, 'Suite familiar con dos habitaciones conectadas', 2);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('73769a0b-d8a5-4bd8-8e6a-c90b292aab54', 'AB-04', 950.00, 250.00, 'Penthouse con terraza privada y vista panorámica', 3);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('73769a0b-d8a5-4bd8-8e6a-c90b292aab54', 'AC-01', 320.00, 95.00, 'Habitación estándar con cama doble y baño privado', 4);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('73769a0b-d8a5-4bd8-8e6a-c90b292aab54', 'AC-02', 370.00, 105.00, 'Habitación con dos camas dobles y escritorio', 5);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('c156d9d6-0405-4e5f-aed6-4a8e656fdda0', 'AC-03', 520.00, 140.00, 'Suite junior con jacuzzi y minibar incluido', 3);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('c156d9d6-0405-4e5f-aed6-4a8e656fdda0', 'AC-04', 780.00, 180.00, 'Suite de lujo con sala, comedor y baño con tina', 4);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('c156d9d6-0405-4e5f-aed6-4a8e656fdda0', 'AD-01', 280.00, 80.00, 'Habitación económica con cama individual', 1);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('c156d9d6-0405-4e5f-aed6-4a8e656fdda0', 'AD-02', 390.00, 100.00, 'Habitación doble estándar con aire acondicionado', 2);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('c156d9d6-0405-4e5f-aed6-4a8e656fdda0', 'AD-03', 610.00, 150.00, 'Suite con cama king y acceso al lounge VIP', 5);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('ddeeeb67-67d7-4705-af25-4be2085a1469', 'AD-04', 990.00, 300.00, 'Presidencial con sala, comedor, jacuzzi y terraza privada', 1);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('ddeeeb67-67d7-4705-af25-4be2085a1469', 'AE-01', 310.00, 85.00, 'Habitación estándar con escritorio y TV plasma', 2);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('ddeeeb67-67d7-4705-af25-4be2085a1469', 'AE-02', 430.00, 120.00, 'Habitación doble con balcón y minibar', 2);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('ddeeeb67-67d7-4705-af25-4be2085a1469', 'AE-03', 670.00, 170.00, 'Suite con dos camas queen y área de descanso', 4);

INSERT INTO hotel.room (hotel_id, room_number, price_per_day, cost_maintenance_per_day, description, capacity)
VALUES ('ddeeeb67-67d7-4705-af25-4be2085a1469', 'AE-04', 880.00, 220.00, 'Suite ejecutiva con oficina privada y vista panorámica', 4);