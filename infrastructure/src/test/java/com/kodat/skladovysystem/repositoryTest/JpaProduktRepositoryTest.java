package com.kodat.skladovysystem.repositoryTest;

import com.kodat.skladovysystem.repository.JpaProduktRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaProduktRepositoryTest {
    @Autowired
    JpaProduktRepository repository;

    @Test
    public void OtestujUlozeniProduktu(){

    }
}
