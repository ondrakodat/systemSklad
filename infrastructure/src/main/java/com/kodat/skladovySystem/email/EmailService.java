package com.kodat.skladovySystem.email;

import com.kodat.skladovysystem.emailEntity.EmailDetails;
import com.kodat.skladovysystem.interfaces.IemailService.IEmailService;

public class EmailService implements IEmailService {
    @Override
    public String posliJednoduchyEmail(EmailDetails emailDetails) {
        return "";
    }

    @Override
    public String posliEmailSPrilohou(EmailDetails emailDetails) {
        return "";
    }
}
