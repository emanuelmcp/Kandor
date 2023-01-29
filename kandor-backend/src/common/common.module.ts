import { Global, Module } from '@nestjs/common';
import { PrismaService } from './prisma/prisma.service';
import { HandlerExceptionService } from './handler-exception/handler-exception.service';

@Global()
@Module({
  providers: [PrismaService, HandlerExceptionService],
  exports: [PrismaService, HandlerExceptionService],
})
export class CommonModule {}
