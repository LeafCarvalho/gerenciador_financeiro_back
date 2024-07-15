package dev.leaf_carvalho.gerenciador_financeiro.service;

import dev.leaf_carvalho.gerenciador_financeiro.model.Investimentos;
import dev.leaf_carvalho.gerenciador_financeiro.repository.InvestimentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentosService {

    private final InvestimentosRepository investimentosRepository;

    public InvestimentosService(InvestimentosRepository investimentosRepository) {
        this.investimentosRepository = investimentosRepository;
    }

    public List<Investimentos> getAllInvestimentos() {
        return investimentosRepository.findAll();
    }

}