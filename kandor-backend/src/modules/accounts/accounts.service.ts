import { Injectable } from '@nestjs/common';
import { CreateAccountDto } from '../../shared/dto/create-account.dto';
import { UpdateAccountDto } from '../../shared/dto/update-account.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Account } from 'src/shared/entities/account.entity';

@Injectable()
export class AccountsService {
  constructor(
    @InjectRepository(Account)
    private readonly accountRepository: Repository<Account>,
  ) {}

  async create(createAccountDto: CreateAccountDto): Promise<Account> {
    try {
      const account = await this.accountRepository.save(createAccountDto);
      return account;
    } catch (error) {}
  }

  findAll() {
    return `This action returns all accounts`;
  }

  async findOne(id: string): Promise<Account> {
    return await this.accountRepository.findOne({ where: { uuid: id } });
  }

  update(id: number, updateAccountDto: UpdateAccountDto) {
    return `This action updates a #${id} account`;
  }

  remove(id: number) {
    return `This action removes a #${id} account`;
  }
}
