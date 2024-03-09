package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.repository.FornecedorRepository;
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
@Path("/fornecedores")
public class FornecedorResource {

     @Inject
        public FornecedorRepository fornecedorRepository;

    @GET
    public List<Fornecedor> findAll() {
        return Fornecedor.listAll();
    }

    @Path("/{id}")
    public Fornecedor findById(@PathParam("id") Long id) {
        return fornecedorRepository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Fornecedor> findByNome(@PathParam("nome") String nome) {
        return fornecedorRepository.findByNome(nome);
    }
    

    @POST
    @Transactional
    public Fornecedor create(Fornecedor fornecedor) {
        fornecedorRepository.persist(fornecedor);
        return fornecedor;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorBanco =  fornecedorRepository.findById(id);

        fornecedorBanco.setNome(fornecedor.getNome());
  
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        fornecedorRepository.deleteById(id);
    }
}
