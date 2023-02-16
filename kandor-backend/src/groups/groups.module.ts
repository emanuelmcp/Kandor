import { Module } from '@nestjs/common';
import { GroupsService } from './groups.service';
import { GroupsController } from '../controllers/groups.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Group } from '../shared/entities/group.entity';

@Module({
  controllers: [GroupsController],
  providers: [GroupsService],
  imports: [TypeOrmModule.forFeature([Group])],
})
export class GroupsModule {}
