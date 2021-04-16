import { Injectable } from '@nestjs/common';
import { resolve } from 'node:path';
import { todoDTO } from './dto/todo.dto';
import { Todo } from './entity/todo.entity';
import { TodoRepository } from './entity/todo.repository';

@Injectable()
export class TodoService {
    constructor(private readonly todoRepository: TodoRepository){}

    getAll(): Promise<Todo[]> {
        return this.todoRepository.find();
    }

    add(body: todoDTO){
        this.todoRepository.save({content: body.content, isCheck: false});
    }

    async check(id: number){
        let todo: Todo = await this.todoRepository.findOne({id: id});
        this.todoRepository.save({id: todo.id, content: todo.content, isCheck: !todo.isCheck});
    }

    async change(id: number, content: string){
        let todo: Todo = await this.todoRepository.findOne({id: id});
        this.todoRepository.save({id: id, content: content, isCheck: todo.isCheck});
    }

    delete(id: number){
        this.todoRepository.delete({id: id});
    }



}
