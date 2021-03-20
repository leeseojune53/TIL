import { Entity, Column, PrimaryGeneratedColumn, BeforeInsert } from 'typeorm';
import { InternalServerErrorException } from '@nestjs/common';

@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  userName: string;

  @Column()
  password: string;

  @BeforeInsert()
  async hashPassword(): Promise<void> {
    try{
      
    }catch(e){
      console.log(e);
      throw new InternalServerErrorException();
    }
  }

}