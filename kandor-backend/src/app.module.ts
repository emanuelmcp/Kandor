import { Module } from '@nestjs/common';
import { CommonModule } from './common/common.module';
import { AccountsModule } from './accounts/accounts.module';

@Module({
  imports: [CommonModule, AccountsModule],
  controllers: [],
  providers: [],
})
export class AppModule {}
