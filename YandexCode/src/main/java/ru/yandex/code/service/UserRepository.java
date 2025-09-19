package ru.yandex.code.service;

public interface UserRepository {
    User findById(Long id);
}
