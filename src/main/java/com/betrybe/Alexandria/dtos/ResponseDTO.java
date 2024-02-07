package com.betrybe.Alexandria.dtos;

public record ResponseDTO<T>(String message, T data) {

}