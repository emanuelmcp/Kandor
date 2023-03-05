import { Type } from 'class-transformer';
import { IsString, IsDate, IsBoolean } from 'class-validator';

export class CreateAccountDto {
  @IsString()
  uuid: string;

  @IsString()
  nick: string;

  @IsString()
  email: string;

  @IsString()
  password: string;

  @Type(() => Date)
  @IsDate()
  lastLogin: Date;

  @IsBoolean()
  logged: boolean;

  @IsBoolean()
  banned: boolean;
}
