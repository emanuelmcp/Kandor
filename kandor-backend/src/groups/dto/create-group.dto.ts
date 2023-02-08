import { IsOptional, IsString } from 'class-validator';
import { Group } from '../entities/group.entity';

export class CreateGroupDto implements Group {
  @IsString()
  groupName: string;

  @IsOptional()
  @IsString()
  description?: string;

  @IsOptional()
  @IsString()
  prefix?: string;

  @IsOptional()
  @IsString()
  suffix?: string;
}
