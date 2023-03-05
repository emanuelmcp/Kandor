import { Module } from '@nestjs/common';
import { CommonModule } from './common/common.module';
import { AccountsModule } from './modules/accounts/accounts.module';
import { GroupsModule } from './modules/groups/groups.module';
import { PermissionsModule } from './modules/permissions/permissions.module';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [
    CommonModule,
    AccountsModule,
    GroupsModule,
    PermissionsModule,
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: 'localhost',
      port: 5432,
      username: 'root',
      password: 'root',
      database: 'test_db',
      autoLoadEntities: true,
      synchronize: true,
      logging: true,
    }),
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
