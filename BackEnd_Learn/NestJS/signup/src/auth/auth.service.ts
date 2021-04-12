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

    async validateUser(useranme: string, pass: string): Promise<boolean> {
        const user = await this.usersService.findOne(useranme);
        if(user && await Bcrypt.compare(pass, user.password)){
            return true;
        }
        return false;
    }

    async login(userId: number){
        const payload = {sub: userId};
        return {
            access_token: this.jwtService.sign(payload),
        }
    };
}
