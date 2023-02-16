import { Module } from '@nestjs/common';
import { AccountsModule } from './accounts/accounts.module';
import { GroupsModule } from './groups/groups.module';
import { CommonModule } from './common/common.module';
import { ConfigModule } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [
    ConfigModule.forRoot(),
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: 'localhost',
      username: 'root',
      password: 'root',
      database: 'test_db',
      logging: true,
      autoLoadEntities: true,
      synchronize: true,
    }),
    AccountsModule,
    GroupsModule,
    CommonModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
