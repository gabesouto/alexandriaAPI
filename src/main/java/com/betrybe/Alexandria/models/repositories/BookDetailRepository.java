package com.betrybe.Alexandria.models.repositories;

import com.betrybe.Alexandria.models.entities.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

}
