@Test
public void testArgumentMatching() {
    ExternalApi mockApi = mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    service.getUserData("admin123");

    verify(mockApi).getUser(eq("admin123"));
}
