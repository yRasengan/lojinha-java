package com.jhondev.model;

public class Produto {
    private static int contador = 1;
    private int id;
   private String nome;
   private double preco;
   
   public Produto (String nome, double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser menor que 0.");
        }

        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
   }

   public int getId() {
    return id;
   }

   public String getNome() {
    return nome;
   }

   public double getPreco() {
    return preco;
   }

   public void setNome(String novoNome) {
    this.nome = novoNome;
   }

   public void setPreco(double novoPreco) {
    if (preco < 0) {
        System.out.println("Preço inválido.");
        return;
    }

    this.preco = novoPreco;
   }

   @Override
   public String toString() {
    return "ID: " + id + " | " + nome + " | R$ " + String.format("%.2f", preco);
   }
}
