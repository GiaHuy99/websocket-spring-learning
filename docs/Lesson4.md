- Message Là "Tin Nhắn Gửi" (Body Từ Client): Trong STOMP, message là body của SEND command – client gửi string/JSON đến /app/chat (prefix app). Spring @MessageMapping("/chat") nhận body này như param method, xử lý (e.g., validate). Tại sao? Để server "hiểu" nội dung tin nhắn trước khi route.
- @SendTo Là "Gửi Đến Địa Chỉ Đúng" (Destination Cho Response): Annotation chỉ định destination (e.g., /topic/chat) để broker gửi response từ method (return value). Broker route đến tất cả SUBSCRIBE địa chỉ đó – /topic cho broadcast (nhiều người nhận). Tại sao? Tự động phân phối mà không code loop connections.
- Flow Hoạt Động: Client SEND /app/chat (message body "Hello") → @MessageMapping nhận → Method return "Echo Hello" → @SendTo("/topic/chat") → Broker broadcast đến subscriber /topic/chat → onmessage nhận body echo.
  - Ví Dụ Thực Tế
    Hãy tưởng tượng app chat Zalo: User A gửi message "Chào bạn!" (body tin nhắn)
    đến /app/chat – @MessageMapping nhận, check spam, return "Echo Chào bạn!"
   @SendTo("/topic/friends") broker gửi đến bạn bè SUBSCRIBE (nhiều tab nhận ngay).
    Nếu không @SendTo, message "kẹt" ở server – giống Telegram route tin đúng group mà không "spam" người lạ!