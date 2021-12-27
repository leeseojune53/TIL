import {Body, Controller, Get, Post, UseGuards} from '@nestjs/common';
import {UsersService} from "./users.service";
import {UserDto} from "./dto/request/users.dto";
import {AuthGuard} from "@nestjs/passport";

@Controller('users')
export class UsersController {
    constructor(
        private readonly usersService: UsersService,
    ) {}

    @Post()
    async registerUser(@Body() body: UserDto) {
        await this.usersService.save(body)
    }

    @UseGuards(AuthGuard('jwt'))
    @Get('information')
    async queryInformation() {
        return this.usersService.queryInformation();
    }

}
