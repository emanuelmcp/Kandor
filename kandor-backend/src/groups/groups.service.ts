import { Injectable } from '@nestjs/common';
import { CreateGroupDto } from '../shared/dto/create-group.dto';
import { UpdateGroupDto } from '../shared/dto/update-group.dto';
import { Group } from '../shared/entities/group.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { HandlerExceptionService } from 'src/common/handler-exception/handler-exception.service';

@Injectable()
export class GroupsService {
  constructor(
    @InjectRepository(Group)
    private readonly groupRepository: Repository<Group>,
    private readonly handleException: HandlerExceptionService,
  ) {}
  async create(createGroupDto: CreateGroupDto) {
    try {
      const account = this.groupRepository.create({ ...createGroupDto });
      await this.groupRepository.insert(account);
      return account;
    } catch (error) {
      this.handleException.handleException(error, createGroupDto.groupName);
    }
  }

  findAll() {
    return `This action returns all groups`;
  }

  findOne(id: number) {
    return `This action returns a #${id} group`;
  }

  update(id: number, updateGroupDto: UpdateGroupDto) {
    return `This action updates a #${id} group`;
  }

  remove(id: number) {
    return `This action removes a #${id} group`;
  }
}
