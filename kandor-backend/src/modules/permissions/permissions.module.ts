import { Module } from '@nestjs/common';
import { PermissionsService } from './permissions.service';
import { PermissionsController } from '../../controllers/permissions.controller';
import { Permission } from '../../shared/entities/permission.entity';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  controllers: [PermissionsController],
  providers: [PermissionsService],
  imports: [TypeOrmModule.forFeature([Permission])],
})
export class PermissionsModule {}
