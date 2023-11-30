package _12.Objetivo05SpringData.exemplares.livros;

import _12.Objetivo05SpringData.exemplares.artigos.Artigo;
import _12.Objetivo05SpringData.exemplares.livros.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void cadastrarLivro(Livro livro) {
        Assert.isNull(livro.getCodigo(),"Não foi possível inserir o registro");
        livroRepository.save(livro);
    }

    public String editarLivro(Long codigo, Livro livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(codigo);

        if (livroExistente.isPresent()) {
            livroRepository.save(livroAtualizado);

            return "Livro alterado com sucesso";
        } else {
            return "Livro não encontrado no sistema";
        }
    }


    public String deletarLivro(Long codigo) {
        Optional<Livro> livroExistente = livroRepository.findById(codigo);

        if (livroExistente.isPresent()) {
            livroRepository.deleteById(codigo);
            return "livro deletado com sucesso";
        } else {
            return "livro não encontrado no sistema";
        }
    }

    public List<Livro> getByNome(String nome) {
        List<Livro> livrosEncontrados = livroRepository.findByNome(nome);
        return livrosEncontrados;
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

}

