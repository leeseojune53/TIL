import {BadRequestException, Injectable} from '@nestjs/common';
import * as Bcrypt from 'bcrypt';
import {JWT_ACCESS_EXP, JWT_REFRESH_EXP, JWT_SECRET} from "./constants";
import {JwtService} from "@nestjs/jwt";
import {UserRequest} from "./dto/request/user.dto";
import { User } from 'src/shared/user/entity/user.entity';
import {UserRepository} from "../shared/user/entity/user.repository";
import {TokenResponse} from "./dto/response/token.dto";

@Injectable()
export class AuthService {
    constructor(
        private userRepository: UserRepository,
        private jwtService: JwtService,
    ){}

    async login(userRequest: UserRequest):Promise<TokenResponse> {
        const user: User = await this.userRepository.findOne({name: userRequest.name});
        console.log(userRequest)
        if(user === undefined)
            throw new BadRequestException("User not found.")
        if(!await Bcrypt.compare(userRequest.password, user.password))
            throw new BadRequestException()

        return new TokenResponse(
            this.jwtService.sign({sub: user.id},
                {secret: JWT_SECRET, expiresIn: JWT_ACCESS_EXP}),
            this.jwtService.sign({sub: user.id},
                {secret: JWT_SECRET, expiresIn: JWT_REFRESH_EXP})
        )
    }

}
