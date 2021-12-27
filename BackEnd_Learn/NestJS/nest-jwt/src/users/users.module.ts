import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UsersService } from './users.service';
import {UserRepository} from "../shared/user/entity/user.repository";
import { UsersController } from './users.controller';

@Module({
  imports: [TypeOrmModule.forFeature([UserRepository])],
  exports: [TypeOrmModule, UsersService],
  providers: [UsersService],
  controllers: [UsersController]
})
export class UsersModule {}
