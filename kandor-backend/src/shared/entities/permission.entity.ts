import { PrimaryGeneratedColumn, Entity, Column } from 'typeorm';

@Entity({ name: 'Permission' })
export class Permission {
  @PrimaryGeneratedColumn()
  permissionId: number;

  @Column()
  permissionName: string;

  @Column()
  description: string;
}
