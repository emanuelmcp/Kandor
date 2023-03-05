import { Module } from '@nestjs/common';
import { AccountsService } from './accounts.service';
import { AccountsController } from '../../controllers/accounts.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Account } from '../../shared/entities/account.entity';

@Module({
  controllers: [AccountsController],
  providers: [AccountsService],
  imports: [TypeOrmModule.forFeature([Account])],
})
export class AccountsModule {}
