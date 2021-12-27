import {Module} from '@nestjs/common';
import {AuthModule} from 'src/auth/auth.module';
import {TypeOrmConfigModule} from 'src/typeorm/typeorm-config.module';
import {UsersModule} from "../users/users.module";

@Module({
    imports: [
        TypeOrmConfigModule,
        UsersModule,
        AuthModule
    ],
})
export class AppModule {
}

