package com.devti.aula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devti.aula.model.Client;
import com.devti.aula.services.ClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClientResource {

	@Autowired
	ClientService serv;	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove cliente")
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Removeu cliente com sucesso"),
    		@ApiResponse(code = 204, message = "Nenhum conteúdo"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
	public void remove(@PathVariable("id")int id) {
		serv.remove(id);
	}
	
	@PutMapping
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Alteração de cliente feita com sucesso"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 404, message = "Cliente não encontrado"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
	@ApiOperation(value = "Altera cliente")
    public Client alter(@RequestBody Client c, @RequestParam("id") int id) {
		c.setId(id);
    	return serv.alter(c);
    }
	
	@PostMapping
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Inseriu cliente com sucesso"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
	@ApiOperation(value = "Insere cliente")
    public Client insertClient(@RequestBody Client c){
        return serv.insert(c);
    }

	@GetMapping
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retornou lista de clientes"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
	@ApiOperation(value = "Lista clientes")
	public List<Client> listAll(){
		return serv.listAll();
	}
	
	@GetMapping("/busca-por-cidade/{cidade}")
	 @ApiResponses(value = {
	    		@ApiResponse(code = 200, message = "Retornou cliente por UF"),
	    		@ApiResponse(code = 401, message = "Sem autorização"),
	    		@ApiResponse(code = 403, message = "Sem permissão"),
	    		@ApiResponse(code = 404, message = "Nenhum cliente encontrado para cidade informada"),
	    		@ApiResponse(code = 500, message = "Exceção")
	    })
	@ApiOperation(value = "Busca cliente por cidade")
    public List<Client> searchByCity(@PathVariable("cidade")String name){
        return serv.findByCity(name);
    }
}
