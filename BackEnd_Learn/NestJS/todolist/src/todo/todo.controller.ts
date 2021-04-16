import { Body, Controller, Get, Param, Patch, Post, Put, Query } from '@nestjs/common';
import { todoDTO } from './dto/todo.dto';
import { TodoService } from './todo.service';

@Controller('todo')
export class TodoController {
    constructor(private readonly todoService: TodoService){}

    @Post()
    async post(@Body() body: todoDTO){
        this.todoService.add(body);
    }

    @Get()
    async getAll() {
        return this.todoService.getAll();
    }

    @Patch('check')
    async check(@Query('id') id: number){
        console.log(id);
        this.todoService.check(id);
    }

    @Put('content')
    async change(@Query('id') id: number, @Body() body: todoDTO){
        this.todoService.change(id, body.content);
    }

}
