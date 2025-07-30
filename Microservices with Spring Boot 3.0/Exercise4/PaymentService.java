@CircuitBreaker(name = "paymentCB", fallbackMethod = "fallbackPayment")
public String callThirdPartyAPI() {
    return webClient.get()
            .uri("https://slowapi.com/payment")
            .retrieve()
            .bodyToMono(String.class)
            .block();
}

public String fallbackPayment(Throwable t) {
    log.error("Fallback triggered: {}", t.getMessage());
    return "Payment service currently unavailable";
}