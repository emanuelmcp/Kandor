import { account } from '@prisma/client';

export class Account implements account {
  uuid: string;
  nick: string;
  email: string;
  password: string;
  last_login: Date;
  logged: boolean;
  banned: boolean;
}
