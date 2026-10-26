package rocks.baksik.searchMicroService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Сервис для работы поиска cdlc",
		version = "1.0.0",
		description = "REST API для шлюза интеграции"),
		servers = @Server(url = "/", description = "Текущий сервер"))
@SpringBootApplication
public class SearchMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchMicroServiceApplication.class, args);
	}


}
