CREATE TABLE IF NOT EXISTS "account"(
    "uuid" VARCHAR(36) PRIMARY KEY,
    "nick" VARCHAR(50) NOT NULL,
    "email" VARCHAR(70) UNIQUE,
    "password" VARCHAR(300) NOT NULL ,
    "login" DATE DEFAULT CURRENT_DATE NOT NULL,
    "logged" BOOLEAN DEFAULT FALSE NOT NULL,
    "banned" BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS "group"(
    "id" SERIAL PRIMARY KEY,
    "name" VARCHAR(50) UNIQUE,
    "description" VARCHAR(100),
    "prefix" VARCHAR(5),
    "suffix" VARCHAR(5)
);
CREATE TABLE IF NOT EXISTS "staff"(
    "account" VARCHAR(36),
    "group" SERIAL,
    CONSTRAINT "staff_pk" PRIMARY KEY ("account", "group"),
    CONSTRAINT "group_fk" FOREIGN KEY("account") REFERENCES "account"("uuid"),
    CONSTRAINT "account_fk" FOREIGN KEY("group") REFERENCES "group"("id")
);
CREATE TABLE IF NOT EXISTS "permissions"(
    "id" SERIAL PRIMARY KEY,
    "name" VARCHAR(50) UNIQUE,
    "description" VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS "access"(
    "group" SERIAL,
    "permission" SERIAL,
    CONSTRAINT "access_pk" PRIMARY KEY ("group", "permission"),
    CONSTRAINT "g_access_fk" FOREIGN KEY("group") REFERENCES "group"("id"),
    CONSTRAINT "p_access_fk" FOREIGN KEY("permission") REFERENCES "permissions"("id")
);

INSERT INTO "account" VALUES ('1a18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel1', 'emanuelmcp1@gmail.com', 'contrasenita1', '2023-01-01', true, false);
INSERT INTO "account" VALUES ('1b18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel2', 'emanuelmcp2@gmail.com', 'contrasenita2', '2023-02-02', true, false);
INSERT INTO "account" VALUES ('1c18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel3', 'emanuelmcp3@gmail.com', 'contrasenita3', '2023-03-03', true, false);
INSERT INTO "account" VALUES ('1d18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel4', 'emanuelmcp4@gmail.com', 'contrasenita4', '2023-04-04', true, false);
INSERT INTO "account" VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel5', 'emanuelmcp5@gmail.com', 'contrasenita5', '2023-05-05', true, false);
INSERT INTO "account" VALUES ('1f18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel6', 'emanuelmcp6@gmail.com', 'contrasenita6', '2023-06-06', true, false);
INSERT INTO "account" VALUES ('1g18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel7', 'emanuelmcp7@gmail.com', 'contrasenita7', '2023-07-07', true, false);
INSERT INTO "account" VALUES ('1h18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel8', 'emanuelmcp8@gmail.com', 'contrasenita8', '2023-08-08', true, false);
INSERT INTO "account" VALUES ('1i18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel9', 'emanuelmcp9@gmail.com', 'contrasenita9', '2023-09-09', true, false);
INSERT INTO "account" VALUES ('1j18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel10', 'emanuelmc10p@gmail.com', 'contrasenita10', '2023-10-10', true, false);
INSERT INTO "account" VALUES ('1k18e9e8-cb2e-412c-a1b7-835e73340d35', 'adariel11', 'emanuelmcp11@gmail.com', 'contrasenita11', '2023-11-11', true, false);

INSERT INTO "group"("name", "description", "prefix", "suffix") VALUES ('default1', 'grupo por defecto1', 'def1', 'def1');
INSERT INTO "group"("name", "description", "prefix", "suffix") VALUES ('default2', 'grupo por defecto2', 'def2', 'def2');
INSERT INTO "group"("name", "description", "prefix", "suffix") VALUES ('default3', 'grupo por defecto3', 'def3', 'def3');

INSERT INTO "staff" VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 1);
INSERT INTO "staff" VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 2);
INSERT INTO "staff" VALUES ('1e18e9e8-cb2e-412c-a1b7-835e73340d35', 3);

