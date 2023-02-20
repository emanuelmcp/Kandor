import { Injectable } from '@nestjs/common';
import { CreatePermissionDto } from '../shared/dto/create-permission.dto';
import { UpdatePermissionDto } from 'src/shared/dto/update-permission.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { HandlerExceptionService } from 'src/common/handler-exception/handler-exception.service';
import { Permission } from '../shared/entities/permission.entity';

@Injectable()
export class PermissionsService {
  constructor(
    @InjectRepository(Permission)
    private readonly groupRepository: Repository<Permission>,
    private readonly handleException: HandlerExceptionService,
  ) {}
  create(createPermissionDto: CreatePermissionDto) {
    return 'This action adds a new permission';
  }

  findAll() {
    return `This action returns all permissions`;
  }

  findOne(id: number) {
    return `This action returns a #${id} permission`;
  }

  update(id: number, updatePermissionDto: UpdatePermissionDto) {
    return `This action updates a #${id} permission`;
  }

  remove(id: number) {
    return `This action removes a #${id} permission`;
  }
}
