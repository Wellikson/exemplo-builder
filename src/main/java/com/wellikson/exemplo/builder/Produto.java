/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wellikson.exemplo.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.immutables.builder.Builder;

/**
 *
 * @author wellikson
 */
public class Produto {

    private long id;
    private String titulo;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque = 0;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private String urlFoto;
    private String categoria;
    private Vendedor vendedor;
    private double peso;
    private double altura;
    private double largura;
    private double profundidade;

    @Builder.Constructor
    public Produto(long id, String titulo, String descricao, String marca,
            String modelo, double preco, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao,
            String urlFoto, String categoria, Vendedor vendedor, double peso, double altura, double largura, double profundidade) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPreco(preco);
        this.setDataCadastro(dataCadastro);
        this.setDataUltimaAtualizacao(dataUltimaAtualizacao);
        this.setUrlFoto(urlFoto);
        this.setCategoria(categoria);
        this.setVendedor(vendedor);
        this.setPeso(peso);
        this.setAltura(altura);
        this.setLargura(largura);
        this.setProfundidade(profundidade);
    }

    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public final void setTitulo(String titulo) {
        if ((titulo == null) || (titulo.isEmpty())) {
           throw new IllegalArgumentException("Titulo ?? obrigat??rio.");
        }
        this.titulo=titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public final void setDescricao(String descricao1) {
        if (descricao1 == null || descricao1.isEmpty()) {
            throw new IllegalArgumentException("Descricao ?? obrigat??rio.");
        }
        this.descricao = descricao1;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;

    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public final void setPreco(double preco) {
        if (preco <= 0 || String.valueOf(preco).isEmpty()) {
            throw new IllegalArgumentException("Pre??o ?? obrigat??rio.");
        }
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public final void setDataCadastro(LocalDate dataCadastro) {
        LocalDate hj = LocalDate.now();
        if (dataCadastro == null || dataCadastro.isBefore(hj)) {
            throw new IllegalArgumentException("Data de cadastro ?? obrigat??rio.");
        }
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public final void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        LocalDate hj = LocalDate.now();
        if (dataUltimaAtualizacao == null || dataUltimaAtualizacao.isBefore(hj)) {
            throw new IllegalArgumentException("Data da atualiza????o ?? obrigat??rio.");
        }
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public final void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getCategoria() {
        return categoria;
    }

    public final void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Categoria ?? obrigat??rio.");
        }
        this.categoria = categoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public final void setVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.equals("")) {
            throw new IllegalArgumentException("Vendedor ?? obrigat??rio.");
        }
        this.vendedor = vendedor;
    }

    public double getPeso() {
        return peso;
    }

    public final void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public final void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public final void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public final void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    @Override
    public String toString() {
        DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String rs = "Produto Id:" + id + "\nTitulo:" + titulo + "\nDescricao:" + descricao;

        if (marca != null && !marca.isEmpty()) {
            rs += "\nMarca:" + marca + "\tModelo:" + modelo;
        }
        rs += "\nEstoque:" + estoque + "\tPre??o:" + preco
                + "\nData Cadastro:" + FORMATO_DATA.format(dataCadastro) + "\tData Ultima Atualiza????o:" + FORMATO_DATA.format(dataUltimaAtualizacao)
                + "\nUrl Foto: " + urlFoto + "\nCategoria:" + categoria + "\nVendedor(a): " + vendedor.getNome()
                + "\nPeso:" + peso + "\tAltura:" + altura + "\tLargura:" + largura + "\tProfundidade:" + profundidade;

        return rs;
    }

}
