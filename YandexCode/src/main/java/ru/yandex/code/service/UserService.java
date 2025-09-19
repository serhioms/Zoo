package ru.yandex.code.service;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserName(Long id) {
        User user = repository.findById(id);
        return user != null ? user.getName() : "Unknown";
    }
}
