package com.rest.helper;


public class TestConstants {

    public static final String SEPARATOR = System.getProperty("file.separator");
    public static
    final String[] PATHS = Thread.currentThread().getContextClassLoader().getResource("").getPath().split("/");
    public static final String VALID_PUBLIC_KEY_PATH = SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources" + SEPARATOR + "public_test.key";
    public static
    final String INVALID_PUBLIC_KEY_PATH = SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources" + SEPARATOR + "invalidPublic_key.key";
    //src\test\resources\invalidPublic_key.key

    public static String getProjectPath() {
        String path = TestConstants.PATHS[1];

        for (int i = 2; !TestConstants.PATHS[i].equals("target"); i++) {
            path += TestConstants.SEPARATOR + TestConstants.PATHS[i];
        }
        return path;
    }



}
