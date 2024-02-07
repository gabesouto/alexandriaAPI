package com.betrybe.Alexandria.enums;

public enum ResponseMessage {
  SUCCESS("Operação realizada com sucesso."),
  NOT_FOUND("Não foi encontrado o recurso."),
  UPDATED("Recurso atualizado com sucesso."),
  REMOVED("Recurso removido com sucesso."),
  CREATED("Recurso criado com sucesso."),
  ERROR("Ocorreu um erro durante a operação.");

  private final String message;

  ResponseMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}