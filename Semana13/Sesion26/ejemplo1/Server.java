import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {

    public static void main(String[] args) {
        int port = 8080; // Puerto en el que escucha el servidor
        String contentFolder = "content"; // Carpeta donde se encuentran los archivos de contenido

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado en el puerto " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Leer la solicitud del cliente
                    StringBuilder request = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        request.append(line).append("\r\n");
                    }

                    // Enviar la respuesta al cliente
                    String response = generateResponse(contentFolder);
                    out.println(response);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateResponse(String contentFolder) {
        StringBuilder response = new StringBuilder();
        try {
            // Leer el contenido de los archivos HTML, CSS e imágenes
            String htmlContent = new String(Files.readAllBytes(Paths.get(contentFolder, "index.html")));
            String cssContent = new String(Files.readAllBytes(Paths.get(contentFolder, "styles.css")));
            byte[] image1Content = Files.readAllBytes(Paths.get(contentFolder, "image1.jpg"));
            byte[] image2Content = Files.readAllBytes(Paths.get(contentFolder, "image2.jpg"));

            // Construir la respuesta HTTP
            response.append("HTTP/1.1 200 OK\r\n");
            response.append("Content-Type: text/html\r\n");
            response.append("\r\n");
            response.append(htmlContent);

            // Adjuntar el contenido del archivo CSS
            response.append("\r\n<style>");
            response.append(cssContent);
            response.append("</style>");

            // Adjuntar el contenido de las imágenes
            response.append("\r\n<img src=\"data:image/jpeg;base64,");
            response.append(java.util.Base64.getEncoder().encodeToString(image1Content));
            response.append("\">");
            response.append("\r\n<img src=\"data:image/jpeg;base64,");
            response.append(java.util.Base64.getEncoder().encodeToString(image2Content));
            response.append("\">");

        } catch (IOException e) {
            e.printStackTrace();
            response.setLength(0);
            response.append("HTTP/1.1 500 Internal Server Error\r\n\r\n");
        }
        return response.toString();
    }
}
