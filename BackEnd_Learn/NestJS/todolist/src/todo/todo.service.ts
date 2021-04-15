import { Injectable } from '@nestjs/common';
import { TodoRepository } from './entity/todo.repository';

@Injectable()
export class TodoService {
    constructor(private readonly todoRepository: TodoRepository){}

    public getAll() {
        return this.todoRepository.
    }

}
