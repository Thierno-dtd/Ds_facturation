package sever.com.serverFacturation.mail;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfController {

    private final EmailService emailService;

    public PdfController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<String> handlePdfUpload(@RequestParam("file") MultipartFile pdfFile,
                                                  @RequestParam("to") String to,
                                                  @RequestParam("subject") String subject,
                                                  @RequestParam("body") String body) {
        try {
            // Logique pour traiter le fichier PDF (enregistrement sur le serveur, etc.)
            // Vous pouvez ajouter ici votre propre logique pour manipuler le fichier PDF avant l'envoi par e-mail.

            // Envoyer le fichier PDF par e-mail
            emailService.sendPdfByEmail(to, subject, body, pdfFile);

            return ResponseEntity.ok("PDF reçu et envoyé par e-mail avec succès !");
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors de la manipulation du PDF ou de l'envoi par e-mail : " + e.getMessage());
        }
    }
}

