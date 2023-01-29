import { Injectable, BadRequestException } from '@nestjs/common';

@Injectable()
export class HandlerExceptionService {
  handleException(error: any) {
    if (error.code === 'P2002')
      throw new BadRequestException('Algo ha salido mal');
    else throw new BadRequestException(error);
  }
}
