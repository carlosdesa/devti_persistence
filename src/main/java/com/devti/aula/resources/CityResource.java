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

import com.devti.aula.model.City;
import com.devti.aula.services.CityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/cidade")
public class CityResource {

    @Autowired
    CityService cityService;
    
    
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Removeu cidade com sucesso"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 404, message = "Cidade não encontrada"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
    @ApiOperation(value = "Remove cidade")
    public void remove(@PathVariable("id") int id) {
    	cityService.remove(id);
    }
    
    @PutMapping
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Alteração de cidade feita com sucesso"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 404, message = "Cidade não encontrada"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
    @ApiOperation(value = "Altera cidade")
    public City alter(@RequestBody City c, @RequestParam("id") int id) {
    	c.setId(id);
    	return cityService.alter(c);
    }
    
    @PostMapping
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Inseriu cidade com sucesso"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
    @ApiOperation(value = "Insere cidade")
    public City insertCity(@RequestBody City c){
        return cityService.insert(c);
    }

    @GetMapping
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retornou lista de cidades"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 404, message = "Cidade não encontrada"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
    @ApiOperation(value = "Lista cidades")
    public List<City> listAll(){
        return cityService.listAll();
    }
    
    @GetMapping("/busca-uf/{uf}")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retornou cidade por UF"),
    		@ApiResponse(code = 401, message = "Sem autorização"),
    		@ApiResponse(code = 403, message = "Sem permissão"),
    		@ApiResponse(code = 404, message = "Cidade não encontrada"),
    		@ApiResponse(code = 500, message = "Exceção")
    })
    @ApiOperation(value = "Busca cidade por UF")
    public List<City> searchByUf(@PathVariable("uf")String uf){
        return cityService.findByUf(uf);
    }
}
