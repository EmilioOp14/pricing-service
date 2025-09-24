USE pricingdb;

-- ============================
-- 1) Payment methods (3)
-- ============================
INSERT IGNORE INTO payment_methods (payment_method) VALUES
  ('Credit Card'),
  ('PayPal'),
  ('Bank Transfer');

-- ============================
-- 2) Prices (6) - 100 y 500 coins por método
--    Evita duplicados con NOT EXISTS
-- ============================

-- Credit Card
INSERT INTO prices (coins_amount, price, method_id)
SELECT 100, 1.99, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='Credit Card'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=100 AND p.method_id=pm.id_payment_method
  );

INSERT INTO prices (coins_amount, price, method_id)
SELECT 500, 8.49, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='Credit Card'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=500 AND p.method_id=pm.id_payment_method
  );

-- PayPal
INSERT INTO prices (coins_amount, price, method_id)
SELECT 100, 2.09, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='PayPal'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=100 AND p.method_id=pm.id_payment_method
  );

INSERT INTO prices (coins_amount, price, method_id)
SELECT 500, 8.79, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='PayPal'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=500 AND p.method_id=pm.id_payment_method
  );

-- Bank Transfer
INSERT INTO prices (coins_amount, price, method_id)
SELECT 100, 1.89, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='Bank Transfer'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=100 AND p.method_id=pm.id_payment_method
  );

INSERT INTO prices (coins_amount, price, method_id)
SELECT 500, 7.99, pm.id_payment_method
FROM payment_methods pm
WHERE pm.payment_method='Bank Transfer'
  AND NOT EXISTS (
    SELECT 1 FROM prices p WHERE p.coins_amount=500 AND p.method_id=pm.id_payment_method
  );

-- ============================
-- 3) Discounts (5)
--    Nota: columna se llama discount_percentaje
--    Hoy (Europe/Madrid): 2025-09-22
-- ============================

-- Pasado: Sep 1–7, 2025 (10%) para 500 coins de TODOS
INSERT INTO discounts (start_date, end_date, discount_percentaje, price_id)
SELECT '2025-09-01 00:00:00', '2025-09-07 23:59:59', 10, p.id_price
FROM prices p
WHERE p.coins_amount = 500
  AND NOT EXISTS (
    SELECT 1 FROM discounts d
    WHERE d.price_id = p.id_price
      AND d.start_date='2025-09-01 00:00:00'
      AND d.end_date='2025-09-07 23:59:59'
  );

-- ACTIVO fin de semana largo: Sep 20–22, 2025 (15%) solo para 500 con Credit Card
INSERT INTO discounts (start_date, end_date, discount_percentaje, price_id)
SELECT '2025-09-20 00:00:00', '2025-09-22 23:59:59', 15, p.id_price
FROM prices p
JOIN payment_methods m ON m.id_payment_method = p.method_id
WHERE p.coins_amount = 500 AND m.payment_method='Credit Card'
  AND NOT EXISTS (
    SELECT 1 FROM discounts d
    WHERE d.price_id = p.id_price
      AND d.start_date='2025-09-20 00:00:00'
      AND d.end_date='2025-09-22 23:59:59'
  );

-- ACTIVO HOY (flash sale): Sep 22, 2025 12:00–23:59 (5%) para 100 con PayPal
INSERT INTO discounts (start_date, end_date, discount_percentaje, price_id)
SELECT '2025-09-22 12:00:00', '2025-09-22 23:59:59', 5, p.id_price
FROM prices p
JOIN payment_methods m ON m.id_payment_method = p.method_id
WHERE p.coins_amount = 100 AND m.payment_method='PayPal'
  AND NOT EXISTS (
    SELECT 1 FROM discounts d
    WHERE d.price_id = p.id_price
      AND d.start_date='2025-09-22 12:00:00'
      AND d.end_date='2025-09-22 23:59:59'
  );

-- Abierto (sin fin): desde Aug 1, 2025 (7%) para 100 con Bank Transfer
INSERT INTO discounts (start_date, end_date, discount_percentaje, price_id)
SELECT '2025-08-01 00:00:00', NULL, 7, p.id_price
FROM prices p
JOIN payment_methods m ON m.id_payment_method = p.method_id
WHERE p.coins_amount = 100 AND m.payment_method='Bank Transfer'
  AND NOT EXISTS (
    SELECT 1 FROM discounts d
    WHERE d.price_id = p.id_price
      AND d.start_date='2025-08-01 00:00:00'
      AND d.end_date IS NULL
  );

-- Futuro: Oct 1–31, 2025 (8%) para 100 con Credit Card
INSERT INTO discounts (start_date, end_date, discount_percentaje, price_id)
SELECT '2025-10-01 00:00:00', '2025-10-31 23:59:59', 8, p.id_price
FROM prices p
JOIN payment_methods m ON m.id_payment_method = p.method_id
WHERE p.coins_amount = 100 AND m.payment_method='Credit Card'
  AND NOT EXISTS (
    SELECT 1 FROM discounts d
    WHERE d.price_id = p.id_price
      AND d.start_date='2025-10-01 00:00:00'
      AND d.end_date='2025-10-31 23:59:59'
  );
