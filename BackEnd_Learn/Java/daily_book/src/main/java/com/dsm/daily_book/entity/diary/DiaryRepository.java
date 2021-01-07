package com.dsm.daily_book.entity.diary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {
}
