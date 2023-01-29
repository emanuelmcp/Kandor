-- CreateTable
CREATE TABLE "account" (
    "uuid" VARCHAR(36) NOT NULL,
    "nick" VARCHAR(50) NOT NULL,
    "email" VARCHAR(70),
    "password" VARCHAR(300) NOT NULL,
    "last_login" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_DATE,
    "logged" BOOLEAN NOT NULL DEFAULT false,
    "banned" BOOLEAN NOT NULL,

    CONSTRAINT "account_pkey" PRIMARY KEY ("uuid")
);

-- CreateTable
CREATE TABLE "account_type" (
    "group_name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(100),
    "prefix" VARCHAR(5),
    "suffix" VARCHAR(5),

    CONSTRAINT "account_type_pkey" PRIMARY KEY ("group_name")
);

-- CreateTable
CREATE TABLE "account_type_permission" (
    "account_uuid" VARCHAR(36) NOT NULL,
    "permission_id" VARCHAR(50) NOT NULL,

    CONSTRAINT "account_type_permission_pk" PRIMARY KEY ("account_uuid","permission_id")
);

-- CreateTable
CREATE TABLE "permission" (
    "permission_name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(100),

    CONSTRAINT "permission_pkey" PRIMARY KEY ("permission_name")
);

-- CreateTable
CREATE TABLE "role_account" (
    "account_uuid" VARCHAR(36) NOT NULL,
    "role_id" VARCHAR(50) NOT NULL,

    CONSTRAINT "role_account_pk" PRIMARY KEY ("account_uuid","role_id")
);

-- CreateIndex
CREATE UNIQUE INDEX "account_email_key" ON "account"("email");

-- AddForeignKey
ALTER TABLE "account_type_permission" ADD CONSTRAINT "role_account_permission_fk" FOREIGN KEY ("permission_id") REFERENCES "permission"("permission_name") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE "account_type_permission" ADD CONSTRAINT "role_account_type_account_fk" FOREIGN KEY ("account_uuid") REFERENCES "account"("uuid") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE "role_account" ADD CONSTRAINT "role_account_account_fk" FOREIGN KEY ("account_uuid") REFERENCES "account"("uuid") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE "role_account" ADD CONSTRAINT "role_account_role_fk" FOREIGN KEY ("role_id") REFERENCES "account_type"("group_name") ON DELETE NO ACTION ON UPDATE NO ACTION;
