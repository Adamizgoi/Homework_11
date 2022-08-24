package ru.netology.homework.productmanager;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
