package io.microsamples.generator.bootswag;

import com.bc.chcs.mask.ToFind;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "io.microsamples.generator.bootswag")
public class BootSwagApplication {

	public static void main(String[] args) {
		ToFind tf = new ToFind();
		SpringApplication.run(BootSwagApplication.class, args);
	}
}
