package giahuypro.lesson2;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @MessageMapping("/chat")  // Nhận SEND /app/chat từ client
    @SendTo("/topic/chat")    // Broker tự broadcast đến SUBSCRIBE /topic/chat
    public String handleAndBroadcast(String message) {
        return "Broadcast qua broker: " + message;  // Echo + route tự động
    }
}
