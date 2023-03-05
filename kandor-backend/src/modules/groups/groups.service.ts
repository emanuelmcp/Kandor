import { Injectable } from '@nestjs/common';
import { CreateGroupDto } from '../../shared/dto/create-group.dto';
import { UpdateGroupDto } from '../../shared/dto/update-group.dto';
import { Repository } from 'typeorm';
import { Group } from 'src/shared/entities/group.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class GroupsService {
  constructor(
    @InjectRepository(Group)
    private readonly groupRepository: Repository<Group>,
  ) {}
  async create(createGroupDto: CreateGroupDto) {
    try {
      return await this.groupRepository.save(createGroupDto);
    } catch (error) {}
  }

  findAll() {
    return `This action returns all groups`;
  }

  findOne(groupName: string) {
    return `This action returns a #${groupName} group`;
  }

  async update(groupName: string, updateGroupDto: UpdateGroupDto) {
    const group = await this.groupRepository.preload({
      groupName,
      ...updateGroupDto,
    });
    try {
      await this.groupRepository.save(group);
    } catch (error) {}
  }

  async remove(groupName: string) {
    try {
      this.groupRepository.delete(groupName);
    } catch (error) {}
  }
}
