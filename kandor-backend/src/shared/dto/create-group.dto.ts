import { IsArray, IsOptional, IsString } from 'class-validator';
import { CreatePermissionDto } from './create-permission.dto';

export class CreateGroupDto {
  @IsString()
  groupName: string;

  @IsString()
  description: string;

  @IsString()
  prefix: string;

  @IsString()
  suffix: string;

  @IsOptional()
  @IsArray()
  permissions?: CreatePermissionDto[];
}
