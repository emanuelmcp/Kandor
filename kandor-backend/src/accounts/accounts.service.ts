import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { CreateAccountDto } from 'src/shared/dto/create-account.dto';
import { UpdateAccountDto } from 'src/shared/dto/update-account.dto';
import { Account } from 'src/shared/entities/account.entity';
import { Group } from 'src/shared/entities/group.entity';
import { Repository } from 'typeorm';

@Injectable()
export class AccountsService {
  constructor(
    @InjectRepository(Account)
    private readonly accountRepository: Repository<Account>,
    @InjectRepository(Group)
    private readonly groupRepository: Repository<Group>,
  ) {}

  async create(createAccountDto: CreateAccountDto) {
    const { groups = [], ...accountDetails } = createAccountDto;
    const account = this.accountRepository.create({
      ...accountDetails,
      groups: groups.map((group) => this.groupRepository.create(group)),
    });
    const savedAccount = await this.accountRepository.save(account);
    return savedAccount;
  }

  findAll() {
    return `This action returns all accounts`;
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
