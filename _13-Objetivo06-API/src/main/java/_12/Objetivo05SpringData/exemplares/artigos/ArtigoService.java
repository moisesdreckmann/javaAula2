package _12.Objetivo05SpringData.exemplares.artigos;

import _12.Objetivo05SpringData.exemplares.artigos.Artigo;
import _12.Objetivo05SpringData.exemplares.artigos.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public void cadastrarArtigo(Artigo artigo) {
        Assert.isNull(artigo.getCodigo(),"Não foi possível inserir o registro");
        artigoRepository.save(artigo);
    }

    public String editarArtigo(Long codigo, Artigo artigoAtualizado) {
        Optional<Artigo> artigoExistente = artigoRepository.findById(codigo);

        if (artigoExistente.isPresent()) {
            artigoRepository.save(artigoAtualizado);

            return "Artigo alterado com sucesso";
        } else {
            return "Artigo não encontrado no sistema";
        }
    }


    public String deletarArtigo(Long codigo) {
        Optional<Artigo> artigoExistente = artigoRepository.findById(codigo);

        if (artigoExistente.isPresent()) {
            artigoRepository.deleteById(codigo);
            return "Artigo deletado com sucesso";
        } else {
            return "Artigo não encontrado no sistema";
        }
    }

    public List<Artigo> getByNome(String nome) {
        List<Artigo> artigosEncontrados = artigoRepository.findByNome(nome);
        return artigosEncontrados;
    }

}


