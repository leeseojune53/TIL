import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm/repository/Repository';
import { UserDto } from './user.dto';
import { User } from './user.entity';
import * as Bcrypt from 'bcrypt';
import { JwtService } from '@nestjs/jwt';
import { AuthService } from 'src/auth/auth.service';

@Injectable()
export class UsersService {
    constructor(
        @InjectRepository(User)
        private userRepository: Repository<User>,
        private authService: AuthService,
    ){}

    async save(userDto: UserDto): Promise<void>{
        let password : string = await Bcrypt.hash(userDto.password, 10);
        this.userRepository.insert({userName: userDto.userName, password: password})
    }

    findAll(): Promise<User[]>{
        return this.userRepository.find();
    }

    async findOne(userName: string): Promise<User> {
        return await this.userRepository.findOne({userName: userName})
    }

    findById(id: number) : Promise<User> {
        return this.userRepository.findOne(id);
    }

    async login(userDto: UserDto) {
        let user: User = await this.userRepository.findOne({userName: userDto.userName})
        if(await this.authService.validateUser(userDto.userName, userDto.password)){
            return this.authService.login(user.id);
        }else return "";
    }

}
