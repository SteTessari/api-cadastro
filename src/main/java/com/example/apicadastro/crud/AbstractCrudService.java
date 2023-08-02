package com.example.apicadastro.crud;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractCrudService<T, ID> implements GeneratorCrudService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public AbstractCrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T create(T entity) {
        tratativasAntesDeInserir(entity);
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        tratativasAntesDeAtualizar(entity);
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
