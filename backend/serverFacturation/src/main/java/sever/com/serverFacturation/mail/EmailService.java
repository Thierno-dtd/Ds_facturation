package sever.com.serverFacturation.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService {
    private JavaMailSender javaMailSender;

    public void sendPdfByEmail(String to, String subject, String body, MultipartFile pdfFile) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        InputStreamSource inputStreamSource = new ByteArrayResource(pdfFile.getBytes());

        // Attachez le fichier PDF
        helper.addAttachment(pdfFile.getOriginalFilename(), inputStreamSource, pdfFile.getContentType());

        javaMailSender.send(message);
    }
}
