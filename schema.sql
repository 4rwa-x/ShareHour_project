CREATE DATABASE IF NOT EXISTS share_hour_db;
USE share_hour_db;

CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS tools (
    tool_id VARCHAR(50) PRIMARY KEY,
    owner_id VARCHAR(50) NOT NULL,
    tool_name VARCHAR(100) NOT NULL,
    hourly_price DOUBLE NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS bookings (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    renter_id VARCHAR(50) NOT NULL,
    tool_id VARCHAR(50) NOT NULL,
    rental_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    total_cost DOUBLE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (renter_id) REFERENCES users(user_id),
    FOREIGN KEY (tool_id) REFERENCES tools(tool_id)
);

-- Insert Sample Users (Owners & Renters)
INSERT INTO users (user_id, full_name, email, role) VALUES
('owner_salim', 'Salim Al-Harthy', 'salim.harthy@email.com', 'OWNER'),
('owner_fatma', 'Fatma Al-Zahra', 'fatma.zahra@email.com', 'OWNER'),
('renter_ahmed', 'Ahmed Al-Busaidi', 'ahmed.busaidi@email.com', 'RENTER'),
('renter_muna', 'Muna Al-Risi', 'muna.risi@email.com', 'RENTER');

-- Insert Sample Tools
INSERT INTO tools (tool_id, owner_id, tool_name, hourly_price) VALUES
('tool_drill_101', 'owner_salim', 'Heavy Duty Electric Drill', 5.0),
('tool_mower_102', 'owner_salim', 'Lawn Mower', 8.0),
('tool_washer_103', 'owner_fatma', 'High Pressure Washer', 6.5);

-- Insert Sample Bookings
INSERT INTO bookings (renter_id, tool_id, rental_date, start_time, end_time, total_cost, status) VALUES
('renter_ahmed', 'tool_drill_101', '2026-10-20', '10:00:00', '13:00:00', 15.0, 'PENDING'),
('renter_muna', 'tool_mower_102', '2026-10-21', '08:00:00', '10:00:00', 16.0, 'APPROVED');
