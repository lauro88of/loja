package com.peixoto.loja.repositorio;

import java.util.List;

public interface Repositorio<T, D> {

    void salvar(T object);

    List<T> buscarTodos();

    T buscarPorCodigo(D codigo);

}
