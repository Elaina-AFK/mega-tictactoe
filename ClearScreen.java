class ClearScreen {
    public ClearScreen() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            ProcessBuilder processBuilder;

            if (os.contains("win")) {
                // For Windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // For Unix/Linux/Mac
                processBuilder = new ProcessBuilder("clear");
            }

            processBuilder.inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
