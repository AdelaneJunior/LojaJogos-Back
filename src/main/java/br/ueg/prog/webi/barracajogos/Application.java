package br.ueg.prog.webi.barracajogos;

import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.repository.AvaliacaoRepository;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
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
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class },
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
	public CommandLineRunner commandLineRunner(JogoRepository jogoRepository, AvaliacaoRepository avaliacaoRepository) {
		return args -> {
			System.out.println("Executado");
			System.out.println(jogoRepository);
			Jogo j1 = new Jogo();
			j1.setNomeJogo("Elden Ring");
			j1.setDesenvolvedora("FromSoftware");
			j1.setCategoria("SoulsLike, OpenWorld");
			j1.setValor(new BigDecimal("250.00"));
			LocalDate lanca = LocalDate.of(2022, Month.FEBRUARY, 25);
			j1.setDataLancamento(lanca);

			try {
				jogoRepository.save(j1);
				
			}catch(Exception e) {
				e.printStackTrace();
			}

			System.out.println("Jogo:"+j1);

			j1 = new Jogo();
			j1.setNomeJogo("Hollow Knight");
			j1.setDesenvolvedora("Team Cherry");
			j1.setCategoria("SoulsLike, Metroidvania");
			j1.setValor(new BigDecimal("46.99"));
			lanca = LocalDate.of(2017, Month.FEBRUARY, 24);
			j1.setDataLancamento(lanca);


			jogoRepository.save(j1);

			System.out.println("Jogo2: "+ j1);
			imprimirLista(jogoRepository);

			Avaliacao avaliacao = new Avaliacao(
					1L,
					j1,
					"Bem legal",
					7,
					null,
					0
			);

			avaliacaoRepository.save(avaliacao);

			System.out.println("Avaliacao: "+ avaliacao);

		};
	}

	private static void imprimirLista(JogoRepository jogoRepository) {
		List<Jogo> lista = jogoRepository.findAll();
		lista.forEach(item -> {
			System.out.println("Jogo: "+item);
		});
	}
}
