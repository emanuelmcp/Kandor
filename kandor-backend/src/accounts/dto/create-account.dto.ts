import { ApiProperty } from '@nestjs/swagger';
import { Exclude } from 'class-transformer';
import {
  IsBoolean,
  IsDateString,
  IsEmail,
  IsOptional,
  IsString,
} from 'class-validator';

export class CreateAccountDto {
  @ApiProperty()
  @IsString()
  uuid: string;

  @ApiProperty()
  @IsString()
  nick: string;

  @ApiProperty()
  @IsOptional()
  @IsEmail()
  email: string;

  @ApiProperty()
  @IsString()
  @Exclude()
  password: string;

  @ApiProperty()
  @IsDateString()
  last_login: Date;

  @ApiProperty()
  @IsBoolean()
  logged: boolean;

  @ApiProperty()
  @IsBoolean()
  banned: boolean;
}
