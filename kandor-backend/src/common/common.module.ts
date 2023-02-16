import { Module } from '@nestjs/common';
import { HandlerExceptionService } from './handler-exception/handler-exception.service';

@Module({
  providers: [HandlerExceptionService]
})
export class CommonModule {}
