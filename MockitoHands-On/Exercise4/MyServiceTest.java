@Test
public void testVoidMethod() {
    ExternalApi mockApi = mock(ExternalApi.class);
    doNothing().when(mockApi).deleteUser(anyString());

    MyService service = new MyService(mockApi);
    service.removeUser("123");

    verify(mockApi).deleteUser("123");
}
