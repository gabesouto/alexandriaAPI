package com.betrybe.Alexandria.models.repositories;

import com.betrybe.Alexandria.models.entities.Author;
import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.entities.Publisher;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
