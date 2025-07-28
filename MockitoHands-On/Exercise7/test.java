@Test
public void testVoidThrowsException() {
    ExternalApi mockApi = mock(ExternalApi.class);
    doThrow(new RuntimeException("Delete error")).when(mockApi).deleteUser("fail");

    MyService service = new MyService(mockApi);

    try {
        service.removeUser("fail");
    } catch (RuntimeException e) {
        assertEquals("Delete error", e.getMessage());
    }

    verify(mockApi).deleteUser("fail");
}