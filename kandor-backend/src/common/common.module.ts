import { Global, Module } from '@nestjs/common';
import { HandlerExceptionService } from './handler-exception/handler-exception.service';

@Global()
@Module({
  providers: [HandlerExceptionService],
  exports: [HandlerExceptionService],
})
export class CommonModule {}
