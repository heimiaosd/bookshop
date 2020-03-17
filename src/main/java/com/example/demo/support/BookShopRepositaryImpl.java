package com.example.demo.support;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class BookShopRepositaryImpl<T,Long> extends SimpleJpaRepository<T,Long> {
    public BookShopRepositaryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public <S extends T> S save(S entity) {
        System.out.println("保存了："+entity.getClass().getSimpleName());
        return super.save(entity);
    }
}
