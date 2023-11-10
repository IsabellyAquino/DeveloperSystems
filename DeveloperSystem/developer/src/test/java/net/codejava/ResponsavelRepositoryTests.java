package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.codejava.responsavel.Responsavel;
import net.codejava.responsavel.ResponsavelRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ResponsavelRepositoryTests {

	@Autowired
	private ResponsavelRepository repo;

	@Test
	public void testCreateResponsavel() {
		Responsavel savedResponsavel = repo.save(new Responsavel("Electronics"));

		assertThat(savedResponsavel.getId()).isGreaterThan(0);
	}
}
