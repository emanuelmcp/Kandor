import { ApiProperty } from '@nestjs/swagger';
import { Type } from 'class-transformer';
import {
  IsBoolean,
  IsDate,
  IsEmail,
  IsOptional,
  IsString,
} from 'class-validator';

export class CreateAccountDto {
  @ApiProperty()
  @IsString()
  readonly uuid: string;

  @ApiProperty()
  @IsString()
  readonly nick: string;

  @ApiProperty()
  @IsOptional()
  @IsEmail()
  readonly email: string;

  @ApiProperty()
  @IsString()
  readonly password: string;

  @ApiProperty()
  @IsDate()
  @Type(() => Date)
  readonly lastLogin: Date;

  @ApiProperty()
  @IsBoolean()
  readonly logged: boolean;

  @ApiProperty()
  @IsBoolean()
  readonly banned: boolean;
}
