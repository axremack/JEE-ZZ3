package app.repositories;

import java.util.List;

import app.entities.PostIt;
import org.springframework.data.repository.CrudRepository;


public interface PostItRepository
        extends CrudRepository<PostIt, Long> {
}