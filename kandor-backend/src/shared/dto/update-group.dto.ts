import { PartialType } from '@nestjs/mapped-types';
import { CreateGroupDto } from './create-group.dto';
import { IsNumber } from 'class-validator';

export class UpdateGroupDto extends PartialType(CreateGroupDto) {
  @IsNumber()
  groupId: number;
}
