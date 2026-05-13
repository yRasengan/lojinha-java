package com.jhondev.service;

import com.jhondev.model.Produto;

import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public boolean removerProduto(int id) {
        Produto p = buscarProduto(id);

        if (p != null) {
            produtos.remove(p);
            return true;
        }

        return false;
    }

    public boolean listaVazia() {
        return produtos.isEmpty();
    }
}
