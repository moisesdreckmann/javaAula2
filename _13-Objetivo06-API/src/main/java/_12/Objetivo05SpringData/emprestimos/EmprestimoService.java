package _12.Objetivo05SpringData.emprestimos;

import _12.Objetivo05SpringData.alunos.Aluno;
import _12.Objetivo05SpringData.alunos.AlunoRepository;
import _12.Objetivo05SpringData.excecoes.NaoEncontradoException;
import _12.Objetivo05SpringData.exemplares.Exemplar;
import _12.Objetivo05SpringData.exemplares.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    public Aluno buscarAluno(Long codigo) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(codigo);

        if (alunoExistente.isPresent()) {
            return alunoExistente.get();
        } else {
            throw new NaoEncontradoException("Houve um erro. Aluno ou exemplar não encontrado!");
        }
    }

    public Exemplar buscarExemplar(Long codigo) {
        Optional<Exemplar> exemplarExistente = exemplarRepository.findById(codigo);

        if (exemplarExistente.isPresent()) {
            return exemplarExistente.get();
        } else {
            throw new NaoEncontradoException("Houve um erro. Aluno ou exemplar não encontrado!");
        }
    }


    public void realizarEmprestimo(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> buscarEmprestimos(Long codigo) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(codigo);

        if(alunoExistente.isPresent()) {
            Aluno aluno = alunoExistente.get();
            return emprestimoRepository.findAll();
        } else {
            return Collections.emptyList();
        }
    }
}
