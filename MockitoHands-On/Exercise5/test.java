@Test
public void testMultipleReturns() {
    ExternalApi mockApi = mock(ExternalApi.class);
    when(mockApi.getData())
        .thenReturn("First Call")
        .thenReturn("Second Call");

    MyService service = new MyService(mockApi);
    assertEquals("First Call", service.fetchData());
    assertEquals("Second Call", service.fetchData());
}