import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { CreateAccountDto } from 'src/shared/dto/create-account.dto';
import { UpdateAccountDto } from 'src/shared/dto/update-account.dto';
import { Account } from 'src/shared/entities/account.entity';
import { Repository } from 'typeorm';
import { HandlerExceptionService } from '../common/handler-exception/handler-exception.service';

@Injectable()
export class AccountsService {
  constructor(
    @InjectRepository(Account)
    private readonly accountRepository: Repository<Account>,
    private readonly handleException: HandlerExceptionService,
  ) {}

  async create(createAccountDto: CreateAccountDto) {
    try {
      const account = this.accountRepository.create({ ...createAccountDto });
      await this.accountRepository.insert(account);
      return account;
    } catch (error) {
      this.handleException.handleException(error, createAccountDto.uuid);
    }
  }

  findAll() {
    return this.accountRepository.find();
  }

  async findOne(uuid: string) {
    return this.accountRepository.findOneBy({ uuid });
  }

  async update(uuid: string, updateAccountDto: UpdateAccountDto) {
    const account = await this.accountRepository.preload({
      uuid,
      ...updateAccountDto,
    });
    return await this.accountRepository.save(account);
  }

  remove(uuid: string) {
    return this.accountRepository.softDelete(uuid);
  }
}
