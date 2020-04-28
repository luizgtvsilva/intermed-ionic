package com.luizgtvsilva.simple.services;

import org.springframework.mail.SimpleMailMessage;

import com.luizgtvsilva.simple.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
