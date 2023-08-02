package br.ueg.prog.webi.barracajogos;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Imagem;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import br.ueg.prog.webi.barracajogos.repository.AvaliacaoRepository;
import br.ueg.prog.webi.barracajogos.repository.ImagemRepository;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
import br.ueg.prog.webi.barracajogos.repository.UsuarioRepository;
import io.swagger.v3.oas.models.Operation;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.method.HandlerMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;


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
    commandLineRunner(JogoRepository jogoRepository, AvaliacaoRepository avaliacaoRepository, UsuarioRepository usuarioRepository, ImagemRepository imagemRepository) {
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
            j1.setNomeJogo("Elden Ring");
            j1.setDesenvolvedora("FromSoftware");
            j1.setCategoria("SoulsLike, OpenWorld");
            j1.setValor(new BigDecimal("250.00"));
            LocalDate lanca = LocalDate.of(2022, Month.FEBRUARY, 25);
            j1.setDataLancamento(lanca);
            j1.setImagem(i1);

            try {
                jogoRepository.save(j1);

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
            j1.setNomeJogo("Hollow Knight");
            j1.setDesenvolvedora("Team Cherry");
            j1.setCategoria("SoulsLike, Metroidvania");
            j1.setValor(new BigDecimal("46.99"));
            lanca = LocalDate.of(2017, Month.FEBRUARY, 24);
            j1.setDataLancamento(lanca);
            j1.setImagem(i1);


            jogoRepository.save(j1);

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

            usuarioRepository.save(user);

            System.out.println(user);

            Avaliacao avaliacao = new Avaliacao(
                    1L,
                    j1,
                    user,
                    "Bem legal",
                    5,
                    null,
                    0
            );

            avaliacaoRepository.save(avaliacao);

            System.out.println("Avaliacao: " + avaliacao);
        };
    }

    @Bean
    public OperationCustomizer operationIdCustomizer() {
        OperationCustomizer c = new OperationCustomizer() {

            @Override
            public Operation customize(Operation operation, HandlerMethod handlerMethod) {
                Class<?> superClazz = handlerMethod.getBeanType().getSuperclass();
                if (Objects.nonNull(superClazz) && superClazz.isAssignableFrom(CrudController.class)) {
                    String beanName = handlerMethod.getBeanType().getSimpleName();
                    operation.setOperationId(String.format("%s_%s", beanName, handlerMethod.getMethod().getName()));
                }
                return operation;
            }
        };
        return c;
    }

    private static void imprimirLista(JogoRepository jogoRepository) {
        List<Jogo> lista = jogoRepository.findAll();
        lista.forEach(item -> {
            System.out.println("Jogo: " + item);
        });
    }
}
