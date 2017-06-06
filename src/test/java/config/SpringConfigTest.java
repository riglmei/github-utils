/**
 * Created by riglesias
 */
package config;

import com.riglesias.githubutils.domain.github.GitHubRepository;
import com.riglesias.githubutils.infrastructure.GitHubRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfigTest {


    @Bean
    public GitHubRepository gitHubRepository(){
        return new GitHubRepositoryImpl();
    }
}
