package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {
     @Inject
    public ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public ProdutoResponseDTO create(@Valid ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setCapacidade(dto.capacidade());
        produto.setCategoria(dto.categoria());
        produto.setDescricao(dto.descricao());
        produto.setEstoque(dto.estoque());
        produto.setFornecedor(dto.fornecedor());

        produtoRepository.persist(produto);
        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void update(Long id, ProdutoDTO dto) {
        Produto produtoBanco =  produtoRepository.findById(id);

        produtoBanco.setNome(dto.nome());
        produtoBanco.setCapacidade(dto.capacidade());
        produtoBanco.setCategoria(dto.categoria());
        produtoBanco.setDescricao(dto.descricao());
        produtoBanco.setEstoque(dto.estoque());
        produtoBanco.setFornecedor(dto.fornecedor());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository
        .listAll()
        .stream()
        .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByNome(String nome) {
        return produtoRepository.findByNome(nome).stream()
        .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }
}
