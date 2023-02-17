import { IsArray, IsString } from 'class-validator';
import { CreateAccountDto } from './create-account.dto';

export class CreateGroupDto {
  @IsString()
  groupName: string;

  @IsString()
  description: string;

  @IsString()
  prefix: string;

  @IsString()
  suffix: string;

  @IsArray()
  accounts: CreateAccountDto[];
}
