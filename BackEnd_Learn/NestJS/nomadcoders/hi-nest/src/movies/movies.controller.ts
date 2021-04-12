import { Body, Controller, Delete, Get, Param, Patch, Post, Put, Query } from '@nestjs/common';
import { CreateMovieDto } from './dto/create-movie.dto';
import { UpdateMovieDto } from './dto/update-movie.dto';
import { Movie } from './entities/Movie.entity';
import { MoviesService } from './movies.service';

@Controller('movies')
export class MoviesController {
    constructor(
        private readonly moviesService: MoviesService
    ){}


    @Get()
    getAll(): Movie[] {
        return this.moviesService.getAll();
    }

    @Get(':id')
    getOne(@Param('id') id: number): Movie {
        return this.moviesService.getOne(id);
    }

    @Post()
    create(@Body() movieData: CreateMovieDto){
        return this.moviesService.create(movieData);
    }

    @Delete(':id')
    delete(@Param('id') movieId: number){
        return this.moviesService.deleteOne(movieId);
    }

    @Patch(':id')
    update(@Param('id') movieId: number, @Body() movieData: UpdateMovieDto){
        return this.moviesService.update(movieId, movieData);
    }

    

}
