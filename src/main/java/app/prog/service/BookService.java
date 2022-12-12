package app.prog.service;

import app.prog.model.BookEntity;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public BookEntity deleteBook(int BookEntityId) {
        Optional<BookEntity> optional = repository.findById(String.valueOf(BookEntityId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Book "+ BookEntityId + " not found");
        }
    }
}
