package giahuypro.lesson4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {
    @MessageMapping("/reply")  // Route /app/send
    @SendTo("/topic/chat")   // Broadcast /topic/chat
    public String handleSimple(String message) {
        System.out.println("Backend nhận message: " + message);  // Log debug
        return "Echo đơn giản: " + message;  // Handle và broadcast
    }
}
