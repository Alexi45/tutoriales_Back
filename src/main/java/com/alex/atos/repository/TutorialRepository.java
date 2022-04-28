package com.alex.atos.repository;

import com.alex.atos.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Tutorial repository.
 */
@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    /**
     * Find by publicado list.
     *
     * @param publicado the publicado
     * @return the list
     */
    List<Tutorial> findByPublicado(boolean publicado);

    /**
     * Find by titulo containing list.
     *
     * @param titulo the titulo
     * @return the list
     */
    List<Tutorial> findByTituloContaining(String titulo);
}
