import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
  Put,
} from '@nestjs/common';
import { GroupsService } from '../modules/groups/groups.service';
import { CreateGroupDto } from '../shared/dto/create-group.dto';
import { UpdateGroupDto } from '../shared/dto/update-group.dto';

@Controller('groups')
export class GroupsController {
  constructor(private readonly groupsService: GroupsService) {}

  @Post()
  create(@Body() createGroupDto: CreateGroupDto) {
    return this.groupsService.create(createGroupDto);
  }

  @Get()
  findAll() {
    return this.groupsService.findAll();
  }

  @Get(':groupName')
  findOne(@Param('groupName') groupName: string) {
    return this.groupsService.findOne(groupName);
  }

  @Post(':groupName')
  update(
    @Param('groupName') groupName: string,
    @Body() updateGroupDto: UpdateGroupDto,
  ) {
    return this.groupsService.update(groupName, updateGroupDto);
  }

  @Delete(':groupName')
  async remove(@Param('groupName') groupName: string) {
    return this.groupsService.remove(groupName);
  }
}
