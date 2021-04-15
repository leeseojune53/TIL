import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity("todo")
export class Todo {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({type: "varchar", length: 256})
    content: string;

    @Column({type: "tinyint"})
    isCheck: boolean;

}