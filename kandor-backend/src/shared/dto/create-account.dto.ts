import { Type } from 'class-transformer';
import {
  IsArray,
  IsBoolean,
  IsDate,
  IsEmail,
  IsOptional,
  IsString,
} from 'class-validator';
import { CreateGroupDto } from './create-group.dto';

export class CreateAccountDto {
  @IsString()
  uuid: string;

  @IsString()
  nick: string;

  @IsEmail()
  email: string;

  @IsString()
  password: string;

  @IsDate()
  @Type(() => Date)
  lastLogin: Date;

  @IsBoolean()
  logged: boolean;

  @IsBoolean()
  banned: boolean;

  @IsOptional()
  @IsArray()
  groups?: CreateGroupDto[];
}
