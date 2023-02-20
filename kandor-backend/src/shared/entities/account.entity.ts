import {
  BeforeInsert,
  BeforeUpdate,
  Column,
  DeleteDateColumn,
  Entity,
  JoinTable,
  ManyToMany,
  PrimaryColumn,
} from 'typeorm';
import { Group } from './group.entity';
import * as bcrypt from 'bcrypt';

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

  @Column()
  logged: boolean;

  @Column()
  banned: boolean;

  @ManyToMany(() => Group, { cascade: ['update'], eager: true })
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

  @BeforeUpdate()
  @BeforeInsert()
  async encryptPassword() {
    const saltOrRounds = 10;
    this.password = await bcrypt.hash(this.password, saltOrRounds);
  }
}
