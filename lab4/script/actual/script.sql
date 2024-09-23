create table actual
(
    uuid       UUID PRIMARY KEY,
    userid     UUID NOT NULL,
    ticketid   UUID NOT NULL,
    fromcity   text,
    tocity     text,
    cost       int,
    expiredate timestamp
);



