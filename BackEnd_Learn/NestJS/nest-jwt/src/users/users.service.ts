import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { AuthService } from 'src/auth/auth.service';
import { Repository } from 'typeorm/repository/Repository';
import * as Bcrypt from 'bcrypt';
import { User } from './user.entity';
import { UserDto } from './users.dto';

@Injectable()
export class UsersService {
    constructor(
        @InjectRepository(User)
        private userRepository: Repository<User>,
    ){}

    async save(userDto: UserDto) {
        let password: string = await Bcrypt.hash(userDto.password);
        this.userRepository.save({userName: userDto.userName, password: userDto.password});
    }

    async findOne(userName: string): Promise<User> {
        return await this.userRepository.findOne({userName: userName});
    }

    findById(id: number) : Promise<User> {
        return this.userRepository.findOne(id);
    }

    async login(userDto: UserDto) {
        let user: User = await this.userRepository.findOne({userName: userDto.userName, })
        
    }
}
