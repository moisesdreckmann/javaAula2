package _12.Objetivo05SpringData.exemplares.periodicos;

import _12.Objetivo05SpringData.exemplares.artigos.Artigo;
import _12.Objetivo05SpringData.exemplares.periodicos.Periodico;
import _12.Objetivo05SpringData.exemplares.periodicos.PeriodicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodicoService {

    @Autowired
    private PeriodicoRepository periodicoRepository;

    public void cadastrarPeriodico(Periodico periodico) {
        Assert.isNull(periodico.getCodigo(),"Não foi possível inserir o registro");
        periodicoRepository.save(periodico);
    }

    public String editarPeriodico(Long codigo, Periodico periodicoAtualizado) {
        Optional<Periodico> periodicoExistente = periodicoRepository.findById(codigo);

        if (periodicoExistente.isPresent()) {
            periodicoRepository.save(periodicoAtualizado);

            return "Periodico alterado com sucesso";
        } else {
            return "Periodico não encontrado no sistema";
        }
    }


    public String deletarPeriodico(Long codigo) {
        Optional<Periodico> periodicoExistente = periodicoRepository.findById(codigo);

        if (periodicoExistente.isPresent()) {
            periodicoRepository.deleteById(codigo);
            return "Periodico deletado com sucesso";
        } else {
            return "Periodico não encontrado no sistema";
        }
    }

    public List<Periodico> getByNome(String nome) {
        List<Periodico> periodicosEncontrados = periodicoRepository.findByNome(nome);
        return periodicosEncontrados;
    }

    public List<Periodico> buscarTodos() {
        return periodicoRepository.findAll();
    }
}
