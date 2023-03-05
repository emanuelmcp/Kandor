import { Column, Entity, JoinTable, ManyToMany, PrimaryColumn } from 'typeorm';
import { Permission } from './permission.entity';
import { Account } from './account.entity';
import { OneToMany } from 'typeorm';

@Entity()
export class Group {
  @PrimaryColumn({ unique: true })
  groupName: string;

  @Column({ nullable: true })
  description: string;

  @Column({ nullable: true })
  prefix: string;

  @Column({ nullable: true })
  suffix: string;

  @ManyToMany(() => Permission)
  @JoinTable({
    name: 'GroupPermissions',
    joinColumn: { name: 'groupName' },
    inverseJoinColumn: { name: 'permissionName' },
  })
  permissions: Permission[];

  @OneToMany(() => Account, (account) => account.group)
  accounts: Account;
}
