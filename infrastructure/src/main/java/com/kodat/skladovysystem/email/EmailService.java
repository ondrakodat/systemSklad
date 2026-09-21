package com.kodat.skladovysystem.email;

import com.kodat.skladovysystem.emailEntity.EmailDetails;
import com.kodat.skladovysystem.interfaces.IemailService.IEmailService;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender javaEmailSender;
    @Value("${spring.mail.username}")
    private String sender;



    @Override
    public String posliJednoduchyEmail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getPrijemce());
            mailMessage.setText(emailDetails.getTeloZpravy());
            mailMessage.setSubject(emailDetails.getPredmetZpravy());
            javaEmailSender.send(mailMessage);
            return "Zprava se uspěšně odeslala.";
        } catch (MailException e) {
            return  "Zprava se nepodařila odeslat " + e.toString();
        }
    }

    @Override
    public String posliEmailSPrilohou(EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaEmailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sender);
            helper.setTo(emailDetails.getPrijemce());
            helper.setText(emailDetails.getTeloZpravy());
            helper.setSubject(emailDetails.getPredmetZpravy());

            FileSystemResource file = new FileSystemResource(new File(emailDetails.getPriloha()));

            helper.addAttachment(file.getFilename(), file);

            javaEmailSender.send(mimeMessage);

            return "Zprava se uspěšně odeslala";
        } catch (MessagingException e) {
            return "Zprava se nepodařila odeslat " + e.getMessage().toString();
        }
    }
    @PostConstruct
    public void test() {
        System.out.println("EMAIL SERVICE VYTVOŘENA");
        System.out.println("SENDER = " + sender);
        System.out.println("JAVA MAIL SENDER = " + javaEmailSender);
    }
}
