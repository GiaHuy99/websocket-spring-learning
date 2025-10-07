# Lesson 2: Comparing WebSocket to HTTP

## What: Key Differences
| Feature        | WebSocket                                 | HTTP                                           |
|----------------|-------------------------------------------|------------------------------------------------|
| TCP Connection | Single, persistent (open once, hold long) | Multiple, short-lived (open/close per request) |
| Communication  | Bidirectional (2-way, full-duplex)        | Unidirectional (request-response, half-duplex) |
| State          | Stateful (session maintained)             | Stateless (each request independent)           |
| Latency        | <10ms (small frames)                      | 100-500ms (polling required for real-time)     |

## Why: Reasons to Choose WebSocket for Real-Time
- HTTP: Good for static (page loads), but polling wastes 90% server CPU.
- WebSocket: Cuts bandwidth 90%, ideal for chat/games—e.g., TradingView live price updates without lag.
 
![Sơ đồ Handshake](images/Screenshot%202025-10-03%20at%2014.31.17.png)

- Broker: distributes messages to the correct destination.
- Broadcast: a function of the Broker that sends a message to all clients.
- STOMP: is protocol of messaging that defines the format and rules for data exchange. protocol of websocket.gi
Noted by: [Gia Huy] - Date: 10/03/2025