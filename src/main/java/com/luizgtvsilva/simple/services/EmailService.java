package com.luizgtvsilva.simple.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.luizgtvsilva.simple.domain.Pedido;

@Service
public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
