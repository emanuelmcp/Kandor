import { Column, Entity, PrimaryGeneratedColumn, ManyToMany } from 'typeorm';
import { Account } from './account.entity';

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
}
