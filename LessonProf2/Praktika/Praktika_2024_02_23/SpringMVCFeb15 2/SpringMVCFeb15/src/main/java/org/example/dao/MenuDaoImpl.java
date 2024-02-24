package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.dish.Dish;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MenuDaoImpl implements MenuDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Dish create(Dish candidate) {
        Objects.requireNonNull(candidate, "Candidate can't be Null");
        entityManager.persist(candidate);
        return readAll().stream().filter(dish -> dish.getName().equals(candidate.getName())).findFirst().orElseThrow();
    }


    @Override
    public Dish read(long id) {
        return entityManager.find(Dish.class, id);
    }

    @Override
    public List<Dish> readAll() {
        return entityManager.createQuery("SELECT d FROM  Dish d", Dish.class).getResultList();
    }

    @Transactional
    @Override
    public Dish update(long id, Dish dish) {
        Objects.requireNonNull(dish);
        dish.setId(id);
        return entityManager.merge(dish);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(read(id));
    }
}
