import { Module } from '@nestjs/common';
import { PrismaService } from './prisma/prisma.service';
import { HandlerExceptionService } from './handler-exception/handler-exception.service';

@Module({
  providers: [PrismaService, HandlerExceptionService]
})
export class CommonModule {}
