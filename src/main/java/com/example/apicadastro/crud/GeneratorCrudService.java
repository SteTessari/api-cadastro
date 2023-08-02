package com.example.apicadastro.crud;

public interface GeneratorCrudService<T, ID> {
    T findById(ID id);

    Iterable<T> findAll();

    T create(T entity);

    T update(T entity);

    void delete(ID id);
    void tratativasAntesDeInserir(T entity);
    void tratativasAntesDeAtualizar(T entity);
}

