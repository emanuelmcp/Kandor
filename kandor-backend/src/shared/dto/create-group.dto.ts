import { IsString } from 'class-validator';

export class CreateGroupDto {
  @IsString()
  groupName: string;

  @IsString()
  description: string;

  @IsString()
  prefix: string;

  @IsString()
  suffix: string;
}
