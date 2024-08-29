package dev.leaf_carvalho.gerenciador_financeiro.controller;

import dev.leaf_carvalho.gerenciador_financeiro.dto.InvestimentosDTO;
import dev.leaf_carvalho.gerenciador_financeiro.model.Investimentos;
import dev.leaf_carvalho.gerenciador_financeiro.service.InvestimentosService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentosController {

    private final InvestimentosService investimentosService;

    public InvestimentosController(InvestimentosService investimentosService) {
        this.investimentosService = investimentosService;
    }

    @GetMapping
    public List<Investimentos> getAllInvestimentos() {
        return investimentosService.getAllInvestimentos();
    }
    
    @GetMapping("/{idInvestimento}")
	public Investimentos getInvestimentosById(@PathVariable("idInvestimento") Long id) {
		return investimentosService.getInvestimentosById(id);
	}
    
    @PostMapping
    public ResponseEntity<Investimentos> saveInvestimentos(@RequestBody InvestimentosDTO investimentosDTO) {
        Investimentos newInvestimento = investimentosService.saveInvestimentos(investimentosDTO);
        return ResponseEntity.status(201).body(newInvestimento);
    }
    
    @DeleteMapping("/{idInvestimento}")
    public void deleteInvestimentos(@PathVariable("idInvestimento") Long id) {
        investimentosService.deleteInvestimentos(id);
    }

}