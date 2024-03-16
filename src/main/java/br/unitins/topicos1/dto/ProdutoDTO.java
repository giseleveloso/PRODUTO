package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProdutoDTO (
    @NotBlank
    (message = "O nome não pode ser nulo ou vazio")
    @Size
    (min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome, 
    String descricao, 
    Fornecedor fornecedor, 
    String capacidade, 
    String categoria, 
    String estoque) {
 }
