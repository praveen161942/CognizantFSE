@Test
public void testInteractionOrder() {
    ExternalApi mockApi = mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    service.fetchData();
    service.getUserData("abc");

    InOrder inOrder = inOrder(mockApi);
    inOrder.verify(mockApi).getData();
    inOrder.verify(mockApi).getUser("abc");
}