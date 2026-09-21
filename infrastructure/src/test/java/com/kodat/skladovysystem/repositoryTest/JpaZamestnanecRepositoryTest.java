package com.kodat.skladovysystem.repositoryTest;

import com.kodat.skladovysystem.repository.JpaZamestnanecRepository;
import com.kodat.skladovysystem.entities.Zamestnanec;
import com.kodat.skladovysystem.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import javax.sql.DataSource;
import java.sql.SQLException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaZamestnanecRepositoryTest {
    @Autowired
    JpaZamestnanecRepository repository;
    @Autowired
    DataSource dataSource;
    @Test
    public void OtestujDatabazi() throws SQLException {
        System.out.println("Datasource url : " + dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    public void OtestujUkladani(){
        Zamestnanec z = new Zamestnanec();
        z.setJmeno("Testovaci");
        z.setPrijmeni("Zamestnanec");
        z.setEmail("testovaciZamestnanec@gmail.com");
        z.setHeslo("testovaciHeslo");
        z.setRole(Role.ADMIN);
        z.setAktivni(false);
        repository.save(z);
    }
}
