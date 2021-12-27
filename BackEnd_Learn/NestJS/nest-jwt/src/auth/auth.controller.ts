import {Body, Controller, Post} from '@nestjs/common';
import {AuthService} from "./auth.service";
import {UserRequest} from './dto/request/user.dto';
import {TokenResponse} from './dto/response/token.dto';

@Controller('auth')
export class AuthController {
    constructor(private readonly authService: AuthService) {}

    @Post()
    async login(@Body() userRequest: UserRequest): Promise<TokenResponse> {
        return this.authService.login(userRequest)
    }

}
