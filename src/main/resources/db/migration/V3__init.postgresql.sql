CREATE SEQUENCE IF NOT EXISTS festivals_id_seq;

CREATE TABLE IF NOT EXISTS festivals (
    id BIGINT PRIMARY KEY DEFAULT nextval('cars_id_seq'),
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    precio INTEGER NOT NULL,
    fecha DATE NOT NULL,
    precio INTEGER NOT NULL,
    estado BOOLEAN,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_festivals_nombre ON festivals (nombre);
CREATE INDEX IF NOT EXISTS idx_festivals_ciudad ON festivals (ciudad);


INSERT INTO festivals (nombre, ciudad, precio, fecha, estado) VALUES
('Rock in Rio', 'Rio de Janeiro', 300, '2024-09-15', TRUE),
('Tomorrowland', 'Boom', 400, '2024-07-20', TRUE),
('Glastonbury', 'Pilton', 250, '2024-06-26', FALSE),
('Coachella', 'Indio', 350, '2024-04-12', TRUE),
('Lollapalooza', 'Chicago', 280, '2024-08-01', TRUE);