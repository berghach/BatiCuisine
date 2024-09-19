-- @block
CREATE TABLE IF NOT EXISTS client(
    id SERIAL,
    name VARCHAR(30),
    adresse VARCHAR(50),
    phone VARCHAR(10),
    is_professional BOOLEAN,
    CONSTRAINT pk_client PRIMARY KEY(id),
    CONSTRAINT must_be_unique_name UNIQUE(name)
);
-- @block
CREATE TYPE project_status AS ENUM('ongoing', 'done', 'canceled');
-- @block
CREATE TABLE IF NOT EXISTS project(
    id SERIAL,
    name VARCHAR(30),
    kitchen_surface NUMERIC,
    profit_margin NUMERIC,
    vat_rate NUMERIC,
    total_price NUMERIC, --Project total_price is the price estimation off taxes and profit margin.
    project_stat project_status,
    client_id INT,
    CONSTRAINT pk_project PRIMARY KEY(id),
    CONSTRAINT fk_client FOREIGN KEY(client_id)
        REFERENCES client(id)
);
-- @block
CREATE TABLE IF NOT EXISTS estimate(
    id SERIAL,
    amount NUMERIC, --Estimete amount is the total project price with taxes and profit margin.
    issue_date DATE,
    validate_date DATE,
    is_accepted BOOLEAN DEFAULT FALSE,
    project_id INT,
    CONSTRAINT pk_estimate PRIMARY KEY(id),
    CONSTRAINT fk_project FOREIGN KEY(project_id)
        REFERENCES project(id)
        ON DELETE CASCADE
);
-- @block
CREATE TYPE component_types AS ENUM('material', 'workforce');
-- @block
CREATE TABLE IF NOT EXISTS component(
    id SERIAL,
    name VARCHAR(30),
    component_type component_types,
    project_id INT,
    CONSTRAINT pk_component PRIMARY KEY(id),
    CONSTRAINT fk_project FOREIGN KEY(project_id)
        REFERENCES project(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS material(
    unit_price NUMERIC,
    quantity NUMERIC,
    vat_rate NUMERIC,
    transport_price NUMERIC,
    quality_coefficient NUMERIC,
    CONSTRAINT pk_component_material PRIMARY KEY(id)
)INHERITS(component);
-- @block
CREATE TYPE workforce_levels AS ENUM('basic', 'skilled');
-- @block
CREATE TABLE IF NOT EXISTS workforce(
    workforce_level workforce_levels,
    hourly_rate NUMERIC,
    work_hours NUMERIC,
    productivity_coefficient NUMERIC,
    CONSTRAINT pk_component_workforce PRIMARY KEY(id)
)INHERITS(component);
-- @block
INSERT INTO client (name, adresse, phone, is_professional)
VALUES 
('John Doe', '123 Main St', '1234567890', FALSE),
('Jane Smith', '456 Oak Ave', '0987654321', TRUE),
('Kitchen Pros', '789 Walnut Blvd', '1122334455', TRUE);
-- @block
INSERT INTO project (name, kitchen_surface, profit_margin, vat_rate, total_price, project_stat, client_id)
VALUES 
('Luxury Kitchen Remodel', 50.5, 0.15, 0.20, NULL, 'ongoing', 1),
('Basic Kitchen Install', 30.0, 0.10, 0.18, NULL, 'done', 2),
('Modern Kitchen Renovation', 45.0, 0.12, 0.19, NULL, 'canceled', 3);
-- @block
INSERT INTO material (id, name, component_type, project_id, unit_price, quantity, vat_rate, transport_price, quality_coefficient)
VALUES 
(1, 'Granite Countertop', 'material', 1, 100, 5, 0.20, 50, 1.2),  -- Luxury Kitchen Remodel
(2, 'Tiles', 'material', 2, 25, 50, 0.18, 30, 1.0),  -- Basic Kitchen Install
(3, 'Lighting Fixtures', 'material', 3, 200, 10, 0.19, 100, 1.3);  -- Modern Kitchen Renovation
-- @block
INSERT INTO workforce (id, name, component_type, project_id, workforce_level, hourly_rate, work_hours, productivity_coefficient)
VALUES 
(4, 'Cabinet Installation', 'workforce', 1, 'skilled', 50, 40, 1.1),  -- Luxury Kitchen Remodel
(5, 'Plumbing', 'workforce', 2, 'basic', 30, 35, 1.0);    -- Basic Kitchen Install
-- @block
UPDATE project
SET total_price = CASE
    WHEN id = 1 THEN 2500
    WHEN id = 2 THEN 2300
    WHEN id = 3 THEN 2000
END;
-- @block
INSERT INTO estimate (amount, issue_date, validate_date, is_accepted, project_id)
VALUES 
(3450, '2023-07-15', '2023-07-20', TRUE, 1),
(2993.16, '2023-06-10', '2023-06-12', TRUE, 2),
(2672.80, '2023-05-01', '2023-05-03', FALSE, 3);
