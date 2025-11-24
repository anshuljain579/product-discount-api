-- =========================================================================
-- Product Discount API - Database Initialization Script
-- =========================================================================

-- Create Product Table
CREATE TABLE IF NOT EXISTS product (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    base_price DOUBLE PRECISION NOT NULL,
    country VARCHAR(50) NOT NULL
);

-- Create Discount Table
CREATE TABLE IF NOT EXISTS discount(
    id SERIAL PRIMARY KEY,
    product_id VARCHAR(50) NOT NULL REFERENCES product(id) ON DELETE CASCADE,
    discount_id DOUBLE PRECISION NOT NULL,
    percent DOUBLE PRECISION NOT NULL CHECK (percent >= 0 AND percent <= 100),
    UNIQUE(product_id, discount_id)
);


-- =========================================================================
-- Some Sample Test Data
-- =========================================================================
INSERT INTO product (id, name, base_price, country) VALUES
('P001', 'Laptop', 1200.00, 'Sweden'),
('P002', 'Smartphone', 800.00, 'Germany'),
('P003', 'Tablet', 400.00, 'France'),
('P004', 'Backpack', 400.00, 'Germany');

INSERT INTO discount (product_id, discount_id, percent) VALUES
('P001', 101, 10.0),
('P001', 102, 5.0),
('P002', 201, 15.0),
('P003', 301, 20.0),
('P004', 401, 25.0);