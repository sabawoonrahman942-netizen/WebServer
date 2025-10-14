import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebServer {

    public static void main(String[] args) {
        final int PORT = 1989;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu " + PORT + " portunda başlatıldı. Tarayıcıdan http://localhost:" + PORT + " adresine gidiniz.");
            while (true) {

                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Yeni bir istemci bağlandı: " + clientSocket.getInetAddress().getHostAddress());

                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true, StandardCharsets.UTF_8);

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

                    String requestLine = in.readLine();
                    System.out.println("İstemci İsteği: " + requestLine);


                    String htmlContent = buildHtmlContent();


                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");

                    int contentLength = htmlContent.getBytes(StandardCharsets.UTF_8).length;
                    out.println("Content-Length: " + contentLength);
                    out.println();


                    out.println(htmlContent);

                    System.out.println("Cevap gönderildi ve istemci bağlantısı kapatıldı.");
                } catch (IOException e) {
                    System.err.println("İstemci bağlantısı kabul edilirken hata oluştu: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Sunucu " + PORT + " portunda başlatılamadı: " + e.getMessage());
        }
    }

    private static String buildHtmlContent() {

        String adSoyad = "Fazl Rahman Sabawoon";
        String ogrenciNo = "5230505100";
        String biyografi = "Yazılım Mühendisliği öğrencisiyim. Java ve ağ programlama konularına " +
                "büyük bir ilgi duyuyorum. Bu proje, socket programlamanın temellerini " +
                "anlamak için harika bir fırsat oldu. Gelecekte dağıtık sistemler ve " +
                "bulut teknolojileri alanında uzmanlaşmayı hedefliyorum.";

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='tr'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset='UTF-8'>");
        htmlBuilder.append("<title>").append(adSoyad).append(" - Web Sunucusu Projesi</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family: 'Arial', sans-serif; background-color: #f0f2f5; color: #333; margin: 40px; }");
        htmlBuilder.append(".container { max-width: 800px; margin: auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
        htmlBuilder.append("h1 { color: #0056b3; }");
        htmlBuilder.append("h2 { color: #5a5a5a; }");
        htmlBuilder.append("p { font-size: 1.1em; line-height: 1.6; color: #444; }");
        htmlBuilder.append("</style>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<div class='container'>");
        htmlBuilder.append("<h1>").append(adSoyad).append("</h1>");
        htmlBuilder.append("<h2>").append(ogrenciNo).append("</h2>");
        htmlBuilder.append("<hr>");
        htmlBuilder.append("<p>").append(biyografi).append("</p>");
        htmlBuilder.append("</div>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
