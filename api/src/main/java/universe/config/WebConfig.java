package universe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Import(AppConfig.class)
@ComponentScan("universe.restController")
public class WebConfig implements WebMvcConfigurer {

//	@Bean
//	public UrlBasedViewResolver viewResolver() {
//		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
//		uBVR.setViewClass(JstlView.class);
//		uBVR.setPrefix("/WEB-INF/views/");
//		uBVR.setSuffix(".jsp");
//		return uBVR;
//	}
}
