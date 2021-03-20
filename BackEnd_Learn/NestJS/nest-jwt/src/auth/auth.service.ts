import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { UsersService } from 'src/users/users.service';
import * as Bcrypt from 'bcrypt';

@Injectable()
export class AuthService {
    constructor(
        private usersService: UsersService,
        private jwtService: JwtService,
    ){}

    async validateUser(username: string, pass: string) {
        const user = await this.usersService.findOne(username);
        if(user && await Bcrypt.compare(pass, user.password)){
            return true;
        }
        return null;
    }

    async login(userId: number){
        const payload = {sub: userId};
        return {
            access_token: this.jwtService.sign(payload)
        }
    }

}
