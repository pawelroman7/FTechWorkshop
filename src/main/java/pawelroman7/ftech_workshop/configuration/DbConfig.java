package pawelroman7.ftech_workshop.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/world-db");
        config.setUsername("world");
        config.setPassword("world123");
        config.setMaximumPoolSize(5);
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }
}
