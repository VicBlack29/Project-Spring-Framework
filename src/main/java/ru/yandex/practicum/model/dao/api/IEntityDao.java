package ru.yandex.practicum.model.dao.api;

import java.util.List;
import java.util.Optional;

public interface IEntityDao<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void save(T t);

    void delete(T t);

}
