package com.kodat.skladovysystem.interfaces.IemailService;
import com.kodat.skladovysystem.emailEntity.EmailDetails;
import jakarta.validation.constraints.Email;

public interface IEmailService {
    String posliJednoduchyEmail(EmailDetails emailDetails);
    String posliEmailSPrilohou(EmailDetails emailDetails);
}
