-- Microservicio de Hoteleria y Habitacion

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA hotel;

CREATE TABLE hotel.hotel (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(100) UNIQUE NOT NULL,
  address TEXT NOT NULL,
  phone VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE hotel.room (
  id SERIAL PRIMARY KEY,
  hotel_id UUID NOT NULL,
  room_number VARCHAR(10) UNIQUE NOT NULL,
  price_per_day NUMERIC(10,2) NOT NULL,
  cost_maintenance_per_day NUMERIC(10,2) NOT NULL,
  description TEXT NOT NULL,
  capacity INTEGER NOT NULL,
  state VARCHAR(20) DEFAULT 'disponible',
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP,
  CONSTRAINT fk_room_hotel FOREIGN KEY (hotel_id) REFERENCES hotel.hotel(id)
);