package com.jhondev.view;

import java.util.Scanner;

import com.jhondev.service.ProdutoService;
import com.jhondev.model.Produto;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private ProdutoService service = new ProdutoService();

    public void iniciar() {
        int opcao;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover por ID");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;

                case 2:
                    service.listarProdutos();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    remover();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (opcao != 0);
    }

    private void cadastrar() {
        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Preço:");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto p = new Produto(nome, preco);

        service.adicionarProduto(p);

        System.out.println("Produto cadastrado!");
    }

    private void buscar() {
        if (service.listaVazia()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto p = service.buscarProduto(id);

        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void remover() {
        if (service.listaVazia()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("Id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removido = service.removerProduto(id);

        if (removido) {
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

}
