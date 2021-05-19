package com.pydio.cells.examples;

public class Upload {

    // FIXME adapt after refactoring

//    private static final String serverURL = "http://localhost:8080";
//    private static final String login = "admin";
//    private static final String pwd = "admin";
//    private static final String workspace = "common-files";
//
//    public static void main(String[] args) {
//        ServerNode node = new ServerNodeImpl();
//        Error error = node.resolve(serverURL);
//        if (error != null) {
//            System.out.println(error);
//            return;
//        }
//
//        Client client = ClientFactory.get(node);
//        client.setCredentials(new LegacyPasswordCredentials(login, pwd));
//        client.setSkipOAuthFlag(true);
//
//
//        String targetDir = "/"; // root
//        String name = "hello.txt";
//
//        byte[] content = "Hello Pydio!".getBytes();
//        ByteArrayInputStream source = new ByteArrayInputStream(content);
//
//        try {
//            Message msg = client.upload(source, content.length, workspace, targetDir, name, true, (progress) -> {
//                System.out.printf("\r%d bytes written\n", progress);
//                return false;
//            });
//            System.out.println("After upload, message: "+msg.message);
//
//        } catch (SDKException e) {
//            e.printStackTrace();
//        }
//    }
}
