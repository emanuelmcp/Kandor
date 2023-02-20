import {
  IsArray,
  IsBoolean,
  IsEmail,
  IsOptional,
  IsString,
  ValidateNested,
} from 'class-validator';
import { Type } from 'class-transformer';
import { UpdateGroupDto } from './update-group.dto';

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

  @ValidateNested({ each: true })
  @Type(() => UpdateGroupDto)
  @IsOptional()
  @IsArray()
  groups?: UpdateGroupDto[];
}
