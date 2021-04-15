import { IsString } from "class-validator";

export class todoDTO {
    @IsString()
    content: string;
}