@Component
public class LogFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Incoming Request URI: " + exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}