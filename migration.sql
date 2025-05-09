create table drinks (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    image_url text,
    S_price float8,
    M_price float8,
    L_price float8
);

create table coffee(
    id uuid primary key default gen_random_uuid(),
    name text not null,
    price float8,
    image_url text,
    origin text,
    in_stock bool
);

create type extra_type as enum ('milk', 'syrup');

create table extras (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    price float8 not null,
    type extra_type not null
);

insert into coffee(name, price, image_url, origin, in_stock) values ('Finca La Hermosa', 175.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/FincaLaHermosa.webp', 'Guatemala', true),
('Finca Santa Maria', 175.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/FincaSantaMaria.webp', 'Nicaragua', true),
('Acacia Core', 149.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/acacia_core.webp', 'Ethiopia', false),
('Finca Las Mercedes "Frankenstein"', 175.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/finca_las_mercedes.webp', 'El Salvador', false),
('Aquiares Estate', 175.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/aquiares_estate.webp', 'Costa Rica', true),
('Dulima', 149.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/ColombiaDulima.webp', 'Colombia', false),
('Fazenda Santa Quitéra', 175.00, 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/coffee%20bags/FazendaSantaQuiteria.webp', 'Brazil', false);

insert into drinks(name, image_url, S_price, L_price) values
('Latte', 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/drinks/Screenshot%202025-05-08%20at%2014.25.29.png',40.00, 45.00),
('Cappuccino', 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/drinks/Screenshot%202025-05-08%20at%2014.25.29.png', 40.00, 45.00),
('Flat White', 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/drinks/Screenshot%202025-05-08%20at%2014.25.29.png', 35.00, 40.00),
('Americano', 'https://kiymqgbxjbwpyppodggo.supabase.co/storage/v1/object/public/shopitems/drinks/Screenshot%202025-05-08%20at%2014.25.29.png', 40.00, 45.00);
insert into drinks(name, image_url) values('Latte', 'google.com');
insert into extras(name, price, type) values('Vanilla', 5, 'syrup');

create type drink_type as enum('coffee','tea','lemonade','milkshake');

alter table drinks
add type drink_type;

insert into drinks(name, image_url, S_price, M_price, L_price, type) values
    ('Black Tea', 'google.com', 30, null, null, 'tea'),
    ('Green Tea', 'google.com', 30, null, null, 'tea'),
    ('Iced Latte', 'google.com', 40, 45, 50, 'coffee'),
    ('Mocha Milkshake', 'google.com', 45, 50, 55, 'milkshake'),
    ('Vanilla Milkshake', 'google.com', 45, 50, 55, 'milkshake');