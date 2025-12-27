package dev.java10x.GestaoDeProjetos.Projetos;

import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {

    public ProjetosModel map(ProjetoDTO projetoDTO) {
        ProjetosModel projetosModel = new ProjetosModel();

        projetosModel.setId(projetoDTO.getId());
        projetosModel.setTitulo(projetoDTO.getTitulo());
        projetosModel.setDescricao(projetoDTO.getDescricao());
        projetosModel.setDataInicio(projetoDTO.getDataInicio());
        projetosModel.setDataFimPrevista(projetoDTO.getDataFimPrevista());
        projetosModel.setStatus(projetoDTO.getStatus());
        projetosModel.setConsultores(projetoDTO.getConsultores());

        return projetosModel;
    }

    public ProjetoDTO map(ProjetosModel projetosModel) {

        ProjetoDTO projetoDTO = new ProjetoDTO();

        projetoDTO.setId(projetosModel.getId());
        projetoDTO.setTitulo(projetosModel.getTitulo());
        projetoDTO.setDescricao(projetosModel.getDescricao());
        projetoDTO.setDataInicio(projetosModel.getDataInicio());
        projetoDTO.setDataFimPrevista(projetosModel.getDataFimPrevista());
        projetoDTO.setStatus(projetosModel.getStatus());
        projetoDTO.setConsultores(projetosModel.getConsultores());

        return projetoDTO;
    }

}
