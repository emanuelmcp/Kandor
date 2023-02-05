CREATE TABLE IF NOT EXISTS "Account"(
    "uuid" VARCHAR(36) PRIMARY KEY,
    "nick" VARCHAR(50) NOT NULL,
    "email" VARCHAR(70) UNIQUE,
    "password" VARCHAR(300) NOT NULL ,
    "lastLogin" TIMESTAMP DEFAULT CURRENT_DATE NOT NULL,
    "logged" BOOLEAN DEFAULT FALSE NOT NULL,
    "banned" BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS "Group"(
    "groupId" SERIAL PRIMARY KEY,
    "groupName" VARCHAR(50),
    "description" VARCHAR(100),
    "prefix" VARCHAR(5),
    "suffix" VARCHAR(5)
);
CREATE TABLE IF NOT EXISTS "Permission"(
    "permissionId" SERIAL PRIMARY KEY,
    "permissionName" VARCHAR(50) UNIQUE,
    "description" VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS "AccountGroup"(
    "accountUuid" VARCHAR(36),
    "groupId" INT,
    CONSTRAINT "accountGroup_pk" PRIMARY KEY ("accountUuid", "groupId"),
    CONSTRAINT "accountGroup_fk1" FOREIGN KEY("accountUuid") REFERENCES "Account"("uuid"),
    CONSTRAINT "accountGroup_fk2" FOREIGN KEY("groupId") REFERENCES "Group"("groupId")
);
CREATE TABLE IF NOT EXISTS "GroupPermission"(
    "groupId" INT,
    "permissionId" INT,
    CONSTRAINT "groupPermission_pk" PRIMARY KEY ("groupId", "permissionId"),
    CONSTRAINT "groupPermission_fk1" FOREIGN KEY("groupId") REFERENCES "Group"("groupId"),
    CONSTRAINT "groupPermission_fk2" FOREIGN KEY("permissionId") REFERENCES "Permission"("permissionId")
);