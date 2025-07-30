@Autowired
private WebClient.Builder webClientBuilder;

public Mono<User> getUserById(Long userId) {
    return webClientBuilder.build()
        .get()
        .uri("http://localhost:8081/users/" + userId)
        .retrieve()
        .bodyToMono(User.class);
}