package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Produto;

public record ProdutoResponseDTO (
    String nome, 
    String descricao, 
    Fornecedor fornecedor, 
    String capacidade, 
    String categoria, 
    String estoque) {
        public static ProdutoResponseDTO valueOf(Produto produto){
            return new ProdutoResponseDTO(
                produto.getNome(), 
                produto.getDescricao(), 
                produto.getFornecedor(), 
                produto.getCapacidade(), 
                produto.getCategoria(), 
                produto.getEstoque());
        }
 }
