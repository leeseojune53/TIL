import {JWT_SECRET} from "../../auth/constants";
import { PassportStrategy } from '@nestjs/passport';
import { ExtractJwt, Strategy } from 'passport-jwt';
import { Injectable } from '@nestjs/common';
import * as dotenv from 'dotenv';
import {UserRepository} from "../user/entity/user.repository";

@Injectable()
export class JwtStrategy extends PassportStrategy(Strategy, 'jwt') {
    constructor(private readonly userRepository: UserRepository) {
        super({
            jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
            ignoreExpiration: false,
            secretOrKey: JWT_SECRET,
        });
    }

    public async validate(payload: any) {
        return this.userRepository.findOne({id: payload.sub});
    }

}