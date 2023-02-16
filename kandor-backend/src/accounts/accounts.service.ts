import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { CreateAccountDto } from 'src/shared/dto/create-account.dto';
import { UpdateAccountDto } from 'src/shared/dto/update-account.dto';
import { Account } from 'src/shared/entities/account.entity';
import { Repository } from 'typeorm';

@Injectable()
export class AccountsService {
  constructor(
    @InjectRepository(Account)
    private readonly accountRepository: Repository<Account>,
  ) {}
  create(createAccountDto: CreateAccountDto) {
    return 'This action adds a new account';
  }

  findAll() {
    return `This action returns all accounts`;
  }

  async findOne(uuid: string) {
    return this.accountRepository.findOneBy({ uuid });
  }

  update(uuid: string, updateAccountDto: UpdateAccountDto) {
    return `This action updates a #${uuid} account`;
  }

  remove(uuid: string) {
    return `This action removes a #${uuid} account`;
  }
}
