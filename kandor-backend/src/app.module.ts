import { Module } from '@nestjs/common';
import { CommonModule } from './common/common.module';
import { AccountsModule } from './accounts/accounts.module';
import { GroupsModule } from './groups/groups.module';

@Module({
  imports: [CommonModule, AccountsModule, GroupsModule],
  controllers: [],
  providers: [],
})
export class AppModule {}
