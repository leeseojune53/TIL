import { Entity, Column, PrimaryGeneratedColumn, Unique } from 'typeorm';

@Unique(['name'])
@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column()
  password: string;

}