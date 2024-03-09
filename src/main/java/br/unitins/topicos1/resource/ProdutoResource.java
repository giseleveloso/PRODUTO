package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/produtos")
public class ProdutoResource {

     @Inject
        public ProdutoRepository produtoRepository;

    @GET
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.listAll().stream().map(p -> ProdutoResponseDTO.valueOf(p)).toList();
    }

    @Path("/{id}")
    public ProdutoResponseDTO findById(@PathParam("id") Long id) {
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<ProdutoResponseDTO> findByNome(@PathParam("nome") String nome) {
        return produtoRepository.findByNome(nome).stream()
        .map(p -> ProdutoResponseDTO.valueOf(p)).toList();
    }
    

    @POST
    @Transactional
    public ProdutoResponseDTO create(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setFornecedor(dto.fornecedor());
        produto.setEstoque(dto.estoque());
        produto.setDescricao(dto.descricao());
        produto.setCategoria(dto.categoria());
        produto.setCapacidade(dto.capacidade());

        return ProdutoResponseDTO.valueOf(produto);

    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, ProdutoDTO dto) {
        Produto produtoBanco =  produtoRepository.findById(id);

        produtoBanco.setNome(dto.nome());
        produtoBanco.setFornecedor(dto.fornecedor());
        produtoBanco.setEstoque(dto.estoque());
        produtoBanco.setDescricao(dto.descricao());
        produtoBanco.setCategoria(dto.categoria());
        produtoBanco.setCapacidade(dto.capacidade());
  
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        produtoRepository.deleteById(id);
    }
}
