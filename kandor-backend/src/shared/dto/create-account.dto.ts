import {
  IsArray,
  IsBoolean,
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

  @IsBoolean()
  logged: boolean;

  @IsBoolean()
  banned: boolean;

  @IsOptional()
  @IsArray()
  groups?: CreateGroupDto[];
}
