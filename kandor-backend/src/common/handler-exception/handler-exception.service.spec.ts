import { Test, TestingModule } from '@nestjs/testing';
import { HandlerExceptionService } from './handler-exception.service';

describe('HandlerExceptionService', () => {
  let service: HandlerExceptionService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [HandlerExceptionService],
    }).compile();

    service = module.get<HandlerExceptionService>(HandlerExceptionService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
