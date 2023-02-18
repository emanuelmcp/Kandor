import {
  Column,
  Entity,
  JoinTable,
  ManyToMany,
  PrimaryGeneratedColumn,
} from 'typeorm';
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

  @ManyToMany(() => Permission, { cascade: true })
  @JoinTable({
    name: 'GroupPermission',
    joinColumn: { name: 'groupId' },
    inverseJoinColumn: { name: 'permissionId' },
  })
  permissions: Permission[];
}
