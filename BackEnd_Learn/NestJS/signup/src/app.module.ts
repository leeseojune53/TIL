import { Module } from '@nestjs/common';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { User } from './users/user.entity';
import { UsersModule } from './users/users.module';
import { AuthModule } from './auth/auth.module';
import { AuthService } from './auth/auth.service';
import { JwtModule, JwtService } from '@nestjs/jwt';
import { UsersService } from './users/users.service';

@Module({
  imports: [
    UsersModule,
    ConfigModule.forRoot({
      isGlobal: true,
      envFilePath: '../.env.dev',
      //envFilePath: process.env.NODE_ENV === '../.env.dev' ? '../.env.test'
    }),
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: process.env.DB_HOST,
      username: 'root',
      password: 'lee@1234',
      port: 3306,
      database: 'nodejs',
      entities: [User],
      synchronize: true
    }),
    ConfigService,
    JwtModule,
    AuthModule
  ],
  controllers: [AppController],
  providers: [AppService, JwtService, AuthService, UsersService],
})
export class AppModule {}
