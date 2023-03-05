import { Test, TestingModule } from '@nestjs/testing';
import { HandlerExceptionsService } from './handler-exceptions.service';

describe('HandlerExceptionsService', () => {
  let service: HandlerExceptionsService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [HandlerExceptionsService],
    }).compile();

    service = module.get<HandlerExceptionsService>(HandlerExceptionsService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
