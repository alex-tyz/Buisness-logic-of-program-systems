create table archive (
    uuid UUID PRIMARY KEY,
    userid UUID NOT NULL,
    ticketid UUID NOT NULL,
    fromcity text,
    tocity text,
    cost int,
    expireDate timestamp
);