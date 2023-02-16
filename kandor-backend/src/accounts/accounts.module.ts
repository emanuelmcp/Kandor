import { Module } from '@nestjs/common';
import { AccountsService } from './accounts.service';
import { AccountsController } from 'src/controllers/accounts.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Account } from '../shared/entities/account.entity';
import { Group } from '../shared/entities/group.entity';

@Module({
  controllers: [AccountsController],
  providers: [AccountsService],
  imports: [TypeOrmModule.forFeature([Account, Group])],
})
export class AccountsModule {}
