package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;

public record ProdutoDTO (
    String nome, 
    String descricao, 
    Fornecedor fornecedor, 
    String capacidade, 
    String categoria, 
    String estoque) {
 }
