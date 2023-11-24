package _12.Objetivo05SpringData.alunos;

import _12.Objetivo05SpringData.alunos.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void cadastrarAluno(Aluno aluno) {
        Assert.isNull(aluno.getCodigo(),"Não foi possível inserir o registro");
        alunoRepository.save(aluno);
    }

    public String editarAlunoPorId(Long codigo, Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(codigo);

        if (alunoExistente.isPresent()) {
            alunoRepository.save(alunoAtualizado);
            return "aluno alterado com sucesso";
        } else {
            return "aluno não encontrado no sistema";
        }
    }

    public String deletarAlunoPorId(Long codigo) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(codigo);

        if (alunoExistente.isPresent()) {
            alunoRepository.deleteById(codigo);
            return "aluno deletado com sucesso";
        } else {
            return "aluno não encontrado no sistema";
        }
    }

    public String getAlunoById(Long codigo) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(codigo);
        if(alunoExistente.isPresent()) {
            return "aluno encontrado: "+ alunoExistente;
        } else {
            return "aluno não encontrado no sistema";
        }
    }

    public List<Aluno> getAlunoByNome(String nome) {
        List<Aluno> alunosEncontrados = alunoRepository.findByNome(nome);
        return alunosEncontrados;
    }

}
