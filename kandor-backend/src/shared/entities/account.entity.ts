import {
  BeforeInsert,
  Column,
  DeleteDateColumn,
  Entity,
  JoinTable,
  ManyToMany,
  PrimaryColumn,
} from 'typeorm';
import { Group } from './group.entity';

@Entity({ name: 'Account' })
export class Account {
  @PrimaryColumn()
  uuid: string;

  @Column()
  nick: string;

  @Column()
  email: string;

  @Column()
  password: string;

  @Column({ type: 'timestamptz' })
  createdAt: Date;

  @DeleteDateColumn({ type: 'timestamptz', nullable: true })
  deletedAt: Date;

  @Column({ type: 'timestamptz' })
  lastLogin: Date;

  @Column()
  logged: boolean;

  @Column()
  banned: boolean;

  @ManyToMany(() => Group, { cascade: true })
  @JoinTable({
    name: 'AccountGroup',
    joinColumn: { name: 'uuid' },
    inverseJoinColumn: { name: 'groupId' },
  })
  groups: Group[];

  @BeforeInsert()
  setStartDate() {
    this.createdAt = new Date();
  }
}
