import { Column, Entity, ManyToMany, PrimaryColumn } from 'typeorm';
import { Group } from './group.entity';

@Entity()
export class Permission {
  @PrimaryColumn()
  permissionName: string;

  @Column()
  description: string;

  @ManyToMany(() => Group)
  groups: Group[];
}
