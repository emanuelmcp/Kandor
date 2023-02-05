import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateAccountDto } from './dto/create-account.dto';
import { UpdateAccountDto } from './dto/update-account.dto';
import { PrismaService } from '../common/prisma/prisma.service';
import { HandlerExceptionService } from '../common/handler-exception/handler-exception.service';

@Injectable()
export class AccountsService {
  constructor(
    private prisma: PrismaService,
    private exception: HandlerExceptionService,
  ) {}

  async create(data: CreateAccountDto): Promise<CreateAccountDto> {
    try {
      const account: CreateAccountDto = await this.prisma.account.create({
        data,
      });
      return account;
    } catch (error) {
      this.exception.handleException(error);
    }
  }

  //TODO: crear paginación
  async findAll() {
    /*const accounts: Account[] = await this.prisma.account.findMany();
    for (let i = 0; i < accounts.length; i++) {
      delete accounts[i].password;
    }
    return accounts;*/
  }

  async findOne(uuid: string) {
    const account = await this.prisma.account.findFirst({
      where: {
        uuid: uuid,
      },
    });
    if (!account)
      throw new NotFoundException(`Account with id ${uuid} not exists`);
    return account;
  }

  update(id: string, updateAccountDto: UpdateAccountDto) {
    return `This action updates a #${id} account`;
  }

  remove(uuid: string) {
    this.prisma.account.delete({
      where: {
        uuid: uuid,
      },
    });
  }
}
