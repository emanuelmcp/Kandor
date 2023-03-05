import { Module } from '@nestjs/common';
import { HandlerExceptionsService } from './handler-exceptions/handler-exceptions.service';

@Module({
  providers: [HandlerExceptionsService]
})
export class CommonModule {}
