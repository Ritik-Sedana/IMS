-- Create Users Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Insert Initial Data (optional)
INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
