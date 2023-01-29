CREATE TABLE IF NOT EXISTS account(
    uuid VARCHAR(36) PRIMARY KEY,
    nick VARCHAR(50) NOT NULL,
    email VARCHAR(70) UNIQUE,
    password VARCHAR(300) NOT NULL ,
    last_login TIMESTAMP DEFAULT CURRENT_DATE NOT NULL,
    logged BOOLEAN DEFAULT FALSE NOT NULL,
    banned BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS account_type(
    group_name VARCHAR(50) PRIMARY KEY,
    description VARCHAR(100),
    prefix VARCHAR(5),
    suffix VARCHAR(5)
);
CREATE TABLE IF NOT EXISTS permission(
    permission_name VARCHAR(50) PRIMARY KEY,
    description VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS role_account(
    account_uuid VARCHAR(36),
    role_id VARCHAR(50),
    CONSTRAINT role_account_pk PRIMARY KEY (account_uuid, role_id),
    CONSTRAINT role_account_account_fk FOREIGN KEY(account_uuid) REFERENCES account(uuid),
    CONSTRAINT role_account_role_fk FOREIGN KEY(role_id) REFERENCES account_type(group_name)
);
CREATE TABLE IF NOT EXISTS account_type_permission(
    account_uuid VARCHAR(36),
    permission_id VARCHAR(50),
    CONSTRAINT account_type_permission_pk PRIMARY KEY (account_uuid, permission_id),
    CONSTRAINT role_account_type_account_fk FOREIGN KEY(account_uuid) REFERENCES account(uuid),
    CONSTRAINT role_account_permission_fk FOREIGN KEY(permission_id) REFERENCES permission(permission_name)
);

