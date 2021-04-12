import { Module } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { UsersModule } from 'src/users/users.module';
import { UsersService } from 'src/users/users.service';
import { AuthService } from './auth.service';
import { jwtConstants } from './constants';

@Module({
    imports: [
        UsersModule,
        JwtModule.register({
            secret: jwtConstants.secret,
            signOptions: {expiresIn: '600s'},
        }),
    ],
    providers: [AuthService],
    exports: [AuthService, JwtModule]
})
export class AuthModule {}
