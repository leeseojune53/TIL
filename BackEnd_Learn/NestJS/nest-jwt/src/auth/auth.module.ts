import {Module} from '@nestjs/common';
import {JwtModule} from '@nestjs/jwt';
import {UsersModule} from 'src/users/users.module';
import {AuthService} from './auth.service';
import {JwtStrategy} from "../shared/auth/jwt.strategy";
import {PassportModule} from "@nestjs/passport";
import { AuthController } from './auth.controller';

@Module({
    imports: [
        UsersModule,
        PassportModule,
        JwtModule.register({}),
    ],
    providers: [AuthService, JwtStrategy],
    exports: [AuthService],
    controllers: [AuthController]
})
export class AuthModule {
}
