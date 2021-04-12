import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { UserDto } from './user.dto';
import { User } from './user.entity';
import { UsersService } from './users.service';

@Controller('users')
export class UsersController {
    constructor(
        private readonly usersService: UsersService
    ){}

    @Post()
    createUser(@Body() userDto: UserDto): Promise<void> {
        return this.usersService.save(userDto);
    }

    @Get('user/:userId')
    findUser(@Param('userId') id: number): Promise<User>{
        return this.usersService.findById(id);
    }

    @Get()
    findAll(): Promise<User[]> {
        return this.usersService.findAll();
    }
    
    @Post('login')
    login(@Body() userDto: UserDto){
        return this.usersService.login(userDto);
    }
    
}
