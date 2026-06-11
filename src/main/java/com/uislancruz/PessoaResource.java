package com.uislancruz;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    public List<Pessoa> getPessoa() {
        return Pessoa.listAll();
    }

    @GET
    @Path("findByAnoNascimento")
    public List<Pessoa> findByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
        return Pessoa.findbyAnoNascimento(anoNascimento);
    }

    @POST
    @Transactional
    public Pessoa createPessoa(Pessoa pessoa){
        pessoa.id = null;
        pessoa.persist();

        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa){
        Pessoa pessoaExistente = Pessoa.findById(pessoa.id);
        pessoaExistente.nome = pessoa.nome;
        pessoaExistente.anoNascimento = pessoa.anoNascimento;
        pessoaExistente.persist();

        return pessoaExistente;
    }

    @DELETE
    @Transactional
    public void deletePessoa(int id){
       Pessoa.deleteById(id);
    }

}
