import {
  BadRequestException,
  Injectable,
  InternalServerErrorException,
  Logger,
} from '@nestjs/common';

@Injectable()
export class HandlerExceptionService {
  handleException(error: any, id: any) {
    if (error.code === '23505')
      throw new BadRequestException(
        `El valor ${id} no puede estar repetido en la base de datos`,
      );
    if (error.code === '9980')
      throw new BadRequestException(
        `El valor ${id} no puede estar repetido en la base de datos`,
      );
    Logger.error(error);
    throw new InternalServerErrorException(`Error inesperado: ${error}`);
  }
}
