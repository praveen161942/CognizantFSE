@Test
public void testVerifyInteraction() {
    ExternalApi mockApi = mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    service.fetchData();

    verify(mockApi).getData(); // Verification
}