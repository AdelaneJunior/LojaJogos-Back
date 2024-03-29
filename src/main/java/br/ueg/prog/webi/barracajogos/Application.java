package br.ueg.prog.webi.barracajogos;

import br.ueg.prog.webi.barracajogos.controller.CarrinhoController;
import br.ueg.prog.webi.barracajogos.dto.CarrinhoDTO;
import br.ueg.prog.webi.barracajogos.model.*;
import br.ueg.prog.webi.barracajogos.repository.AvaliacaoRepository;
import br.ueg.prog.webi.barracajogos.repository.ImagemRepository;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
import br.ueg.prog.webi.barracajogos.repository.UsuarioRepository;
import br.ueg.prog.webi.barracajogos.service.JogoCarrinhoService;
import br.ueg.prog.webi.barracajogos.service.impl.CarrinhoServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@SpringBootApplication(
        scanBasePackages = {
                "br.ueg.prog.webi.*",
                //Para funcionamento da Arquitetura
                "br.ueg.prog.webi.api.*", "br.ueg.prog.webi.*"}
)
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {
                "br.ueg.prog.webi.*",
                //Para funcionamento da Arquitetura
                "br.ueg.prog.webi.api.*"}
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner
    commandLineRunner(JogoRepository jogoRepository, AvaliacaoRepository avaliacaoRepository,
                      UsuarioRepository usuarioRepository, ImagemRepository imagemRepository,
                      CarrinhoServiceImpl carrinhoService, JogoCarrinhoService jogoCarrinhoService,
                      CarrinhoController carrinhoController) {
        return args -> {
            System.out.println("Executado");
            System.out.println(jogoRepository);

            Imagem i1 = new Imagem();
            i1.setTipo("image/jpeg");
            i1.setCaminhoArq("C:\\Users\\Delane Jr\\Documents\\Facul\\5ºSemestre\\Programação Web I\\1ºBimestre\\BarracaDeJogos-Front\\src\\assets\\elden.jpg");
            i1.setNome("elden.jpg");
            i1.setPathReference("assets/elden.jpg");

            try {
                i1 = imagemRepository.save(i1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Jogo j1 = new Jogo();
            j1.setNome("Elden Ring");
            j1.setDesenvolvedora("FromSoftware");
            j1.setCategoria("SoulsLike, OpenWorld");
            j1.setValor(new BigDecimal("250.00"));
            LocalDate lanca = LocalDate.of(2022, Month.FEBRUARY, 25);
            j1.setDataLancamento(lanca);
            j1.setImagem(i1);

            try {
                j1 = jogoRepository.save(j1);

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Jogo:" + j1);

            i1 = new Imagem();
            i1.setTipo("image/jpgeg");
            i1.setCaminhoArq("C:\\Users\\Delane Jr\\Documents\\Facul\\5ºSemestre\\Programação Web I\\1ºBimestre\\BarracaDeJogos-Front\\src\\assets\\hollow.jpg");
            i1.setNome("hollow.jpg");
            i1.setPathReference("assets/hollow.jpg");

            try {
                i1 = imagemRepository.save(i1);
            } catch (Exception e) {
                e.printStackTrace();
            }


            j1 = new Jogo();
            j1.setNome("Hollow Knight");
            j1.setDesenvolvedora("Team Cherry");
            j1.setCategoria("SoulsLike, Metroidvania");
            j1.setValor(new BigDecimal("46.99"));
            lanca = LocalDate.of(2017, Month.FEBRUARY, 24);
            j1.setDataLancamento(lanca);
            j1.setImagem(i1);


            j1 = jogoRepository.save(j1);

            System.out.println("Jogo2: " + j1);
            imprimirLista(jogoRepository);


            Usuario user = new Usuario();
            user.setNome("Ademir");
            user.setSenha("admin");
            user.setLogin("admin");
            user.setStatus(true);
            user.setRole("ROLE_ADMIN");
            user.setEmail("admin@gmail.com");
            user.setCodigo(null);
            user.setCarrinho(new Carrinho());

           user = usuarioRepository.save(user);

            System.out.println(user);

            Avaliacao avaliacao = new Avaliacao(
                    1L, j1, user, "bom", 5L, 2.1D
            );

           avaliacao = avaliacaoRepository.save(avaliacao);

            System.out.println("Avaliacao: " + avaliacao);

            System.out.println(carrinhoService.listarTodos());

            Carrinho carrinho = carrinhoService.obterPeloId(user.getCarrinho().getCodigo());

            JogoCarrinho jogoCarrinho = new JogoCarrinho();
            jogoCarrinho.setJogo(j1);
            jogoCarrinho.setDesconto(BigDecimal.valueOf(10));
            jogoCarrinho.setQuantidade(3L);

            carrinho.getJogoCarrinho().add(jogoCarrinho);

            jogoCarrinho = new JogoCarrinho();
            jogoCarrinho.setJogo(new Jogo());
            jogoCarrinho.getJogo().setCodigo(1L);
            jogoCarrinho.setDesconto(BigDecimal.valueOf(5));
            jogoCarrinho.setQuantidade(1L);

            carrinho.getJogoCarrinho().add(jogoCarrinho);

            carrinho = carrinhoService.alterar(carrinho , carrinho.getCodigo());

            CarrinhoDTO carrinhoDTO = carrinhoController.ObterPorId(user.getCarrinho().getCodigo()).getBody();
            System.out.println(carrinhoDTO);
        };
    }

    private static void imprimirLista(JogoRepository jogoRepository) {
        List<Jogo> lista = jogoRepository.findAll();
        lista.forEach(item -> {
            System.out.println("Jogo: " + item);
        });
    }
}
