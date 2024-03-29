package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.exception.ApiMessageCode;
import br.ueg.prog.webi.api.exception.BusinessException;
import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Imagem;
import br.ueg.prog.webi.barracajogos.repository.ImagemRepository;
import br.ueg.prog.webi.barracajogos.service.ImagemService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class ImagemServiceImpl extends BaseCrudService<Imagem, Long, ImagemRepository> implements ImagemService {

    @Autowired
    private ImagemRepository repository;

    private final String CAMINHO_PASTA = "C:\\Users\\Delane Jr\\Documents\\Facul\\5ºSemestre\\Programação Web I\\1ºBimestre\\BarracaDeJogos-Front\\src\\assets";
    private final String PATH_REFERENCE = "assets";

    @Override
    protected void prepararParaIncluir(Imagem entidade) {

    }

    @Override
    protected void validarDados(Imagem entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Imagem entidade) {

    }

    public Long incluir(MultipartFile imagemASalvar) throws IOException {

        String caminhoArquivo = CAMINHO_PASTA + "\\" + LocalDate.now() + imagemASalvar.getOriginalFilename();
        String pathReference = PATH_REFERENCE + "/" + LocalDate.now() + imagemASalvar.getOriginalFilename();

        try {
            Imagem imagem = this.repository.save(Imagem.builder()
                    .nome(imagemASalvar.getOriginalFilename())
                    .tipo(imagemASalvar.getContentType())
                    .caminhoArq(caminhoArquivo)
                    .pathReference(pathReference)
                    .build());

            imagemASalvar.transferTo(new File(caminhoArquivo));

            return imagem.getId();
        } catch (DataIntegrityViolationException | ConstraintViolationException var3) {
            throw new BusinessException(ApiMessageCode.ERRO_BD, new Object[]{var3.getMessage()});
        }
    }

    @Override
    public Imagem excluir(Long id) {
        Imagem imagemExcluir = super.excluir(id);
        File file = new File(imagemExcluir.getCaminhoArq());
        if(file.delete()){
            return imagemExcluir;
        }
        return null;
    }
}
