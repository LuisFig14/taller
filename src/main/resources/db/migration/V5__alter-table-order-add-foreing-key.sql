ALTER TABLE orders ADD CONSTRAINT fk_orders_clients FOREIGN KEY (id_client) REFERENCES clients(id_client);
