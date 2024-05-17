/**
  SCRIPT CREATED USING SQLITE MIGRATION
 */

create table Distributors
(
    DistributorId   TEXT    not null
        constraint PK_Distributors
            primary key,
    DistributorCode TEXT    not null,
    DistributorName TEXT    not null,
    Address         TEXT    not null,
    EmailAddress    TEXT    not null,
    PhoneNumber     TEXT    not null,
    ContactPerson   TEXT    not null,
    IsDeleted       INTEGER not null,
    CreatedAt       TEXT    not null,
    LastModifiedAt  TEXT
);

create table Spectacles
(
    SpectacleId    TEXT    not null
        constraint PK_Spectacles
            primary key,
    SpectacleCode  TEXT    not null,
    SpectacleType  TEXT    not null,
    SpectacleBrand TEXT    not null,
    Price          TEXT    not null,
    Stock          INTEGER not null,
    DistributorId  TEXT    not null
        constraint FK_Spectacles_Distributors_DistributorId
            references Distributors
            on delete cascade,
    IsDeleted      INTEGER not null,
    CreatedAt      TEXT    not null,
    LastModifiedAt TEXT
);

create index IX_Spectacles_DistributorId
    on Spectacles (DistributorId);

create table __EFMigrationsHistory
(
    MigrationId    TEXT not null
        constraint PK___EFMigrationsHistory
            primary key,
    ProductVersion TEXT not null
);


INSERT INTO Spectacles (SpectacleId, SpectacleCode, SpectacleType, SpectacleBrand, Price, Stock, DistributorId, CreatedAt, LastModifiedAt, IsDeleted) VALUES
('2613b9f0-1f36-48f7-8796-d4aa5865faf5','L001','Tunggal','Hoya',700000,70,'3670543b-f5e5-4ff3-90de-3e17aa9324f2',time('now'), time('now'), 0),
('8cc215f8-9f4f-4a94-87cf-5b62af04b628','L002','Bifokal','Zeiss',800000,40,'a99dc5c1-b094-4e29-886b-f007d2e883df',time('now'), time('now'), 0),
('796af8df-95c0-48d1-b645-80c9bb333944','L003','Progresif','Oakley',850000,30,'a99dc5c1-b094-4e29-886b-f007d2e883df',time('now'), time('now'), 0),
('f85c211d-7de3-4af8-bdce-81b69a33a589','L004','Transisi','Essilor',975000,10,'3670543b-f5e5-4ff3-90de-3e17aa9324f2',time('now'), time('now'), 0);

INSERT INTO Distributors (DistributorId, DistributorCode, DistributorName, Address, EmailAddress, PhoneNumber, ContactPerson, CreatedAt, LastModifiedAt, IsDeleted) VALUES
('3670543b-f5e5-4ff3-90de-3e17aa9324f2', 'S001','PT. Asparindo Nusaphala','Bekasi','aspar@indo.com', '+6200137','Budi', time('now'), time('now'), 0),   
('a99dc5c1-b094-4e29-886b-f007d2e883df', 'S002','CV. Multi Industrindo','Jakarta','multi@indo.com', '+6200123','Didu', time('now'), time('now'), 0);