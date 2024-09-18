create table actual
(
    uuid       UUID PRIMARY KEY,
    userid     UUID NOT NULL,
    ticketid   UUID NOT NULL,
    fromCity   text,
    toCity     text,
    cost       int,
    expireTime timestamp
);