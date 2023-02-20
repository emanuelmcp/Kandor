import {
  Column,
  Entity,
  PrimaryGeneratedColumn,
  ManyToMany,
  JoinTable,
} from 'typeorm';
import { Account } from './account.entity';
import { Permission } from './permission.entity';

@Entity({ name: 'Group' })
export class Group {
  @PrimaryGeneratedColumn()
  groupId: number;

  @Column({ unique: true })
  groupName: string;

  @Column({ nullable: true })
  description: string;

  @Column({ nullable: true })
  prefix: string;

  @Column({ nullable: true })
  suffix: string;

  @ManyToMany(() => Account)
  accounts: Account[];

  @ManyToMany(() => Permission, { cascade: ['update'], eager: true })
  @JoinTable({
    name: 'GroupPermission',
    joinColumn: { name: 'groupId' },
    inverseJoinColumn: { name: 'permissionId' },
  })
  permissions: Permission[];
}
