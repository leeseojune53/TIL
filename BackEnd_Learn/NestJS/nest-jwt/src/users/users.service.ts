import {BadRequestException, Inject, Injectable} from '@nestjs/common';
import * as bcrypt from 'bcrypt';
import { UserDto } from './dto/request/users.dto';
import { UserRepository } from 'src/shared/user/entity/user.repository';
import {REQUEST} from "@nestjs/core";
import {Request} from "express";
import {User} from "../shared/user/entity/user.entity";
import {InformationResponse} from "./dto/response/information.dto";

@Injectable()
export class UsersService {
    constructor(
        private readonly userRepository: UserRepository,
        @Inject(REQUEST) readonly request: Request
    ){}

    async save(userDto: UserDto) {
        if(await this.userRepository.findOne({name: userDto.name})){
            throw new BadRequestException("Duplicated name.")
        }
        const password: string = await bcrypt.hash(userDto.password, 12);
        await this.userRepository.save({name: userDto.name, password: password});
    }

    async queryInformation() {
        const user = (this.request.user as User)
        return new InformationResponse(user.id, user.name)
    }

}
