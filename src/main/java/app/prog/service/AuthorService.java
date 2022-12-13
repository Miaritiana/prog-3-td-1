package app.prog.service;

import app.prog.model.Author;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import app.prog.exception.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<Author> getAuthors(){
        return repository.findAll();
    }

    public List<Author> createAuthors(List<Author> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Author> updateAuthors(List<Author> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Author deleteBook(int AuthorId) {
        Optional<Author> optional = repository.findById(AuthorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new NotFoundException("AuthorEntity." + id + " not found");
        }
    }
}
