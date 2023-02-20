import { PrimaryGeneratedColumn, Entity, Column, ManyToMany } from 'typeorm';
import { Group } from './group.entity';

@Entity({ name: 'Permission' })
export class Permission {
  @PrimaryGeneratedColumn()
  permissionId: number;

  @Column({ unique: true })
  permissionName: string;

  @Column()
  description: string;

  @ManyToMany(() => Group)
  groups: Group[];
}
