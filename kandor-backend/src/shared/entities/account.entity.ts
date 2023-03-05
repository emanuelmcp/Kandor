import { Column, Entity, ManyToOne, PrimaryColumn } from 'typeorm';
import { Group } from './group.entity';

@Entity()
export class Account {
  @PrimaryColumn()
  uuid: string;

  @Column()
  nick: string;

  @Column({ nullable: true })
  email: string;

  @Column()
  password: string;

  @Column({ type: 'timestamptz' })
  lastLogin: Date;

  @Column()
  logged: boolean;

  @Column()
  banned: boolean;

  @ManyToOne(() => Group, (group) => group.accounts)
  group: Group;
}
