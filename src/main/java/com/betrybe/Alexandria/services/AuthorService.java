package com.betrybe.Alexandria.services;

import com.betrybe.Alexandria.models.entities.Author;
import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.repositories.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  private AuthorRepository AuthorRepository;

  @Autowired
  public AuthorService(AuthorRepository authorRepository) {
    this.AuthorRepository = authorRepository;
  }

  public Author insertAuthor(Author author) {
    return AuthorRepository.save(author);
  }


  public Optional<Author> updateAuthor(Long id, Author author) {
    Optional<Author> optionalAuthor = AuthorRepository.findById(id);

    if (optionalAuthor.isPresent()) {
      Author authorFromDb = optionalAuthor.get();
      authorFromDb.setName(author.getNationality());
      authorFromDb.setName(author.getName());

      Author updatedAuthor = AuthorRepository.save(authorFromDb);
      return Optional.of(updatedAuthor);

    }

    return optionalAuthor;
  }

  public Optional<Author> removeAuthorById(Long id) {
    Optional<Author> authorOptional = AuthorRepository.findById(id);

    if (authorOptional.isPresent()) {
      AuthorRepository.deleteById(id);
    }

    return authorOptional;
  }

  public Optional<Author> getAuthorById(Long id) {
    return AuthorRepository.findById(id);
  }

  public List<Author> getAllAuthors() {
    return AuthorRepository.findAll();
  }

}
