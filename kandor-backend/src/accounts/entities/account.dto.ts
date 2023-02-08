import { Exclude, Type } from 'class-transformer';
import { IsBoolean, IsDate, IsEmail, IsString } from 'class-validator';

export class AccountDTO {
  @IsString()
  uuid: string;

  @IsString()
  nick: string;

  @IsEmail()
  email: string;

  @Exclude()
  @IsString()
  password: string;

  @IsDate()
  @Type(() => Date)
  lastLogin: Date;

  @IsBoolean()
  logged: boolean;

  @IsBoolean()
  banned: boolean;
}
