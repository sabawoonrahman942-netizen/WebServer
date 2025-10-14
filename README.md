Web Sunucusu Projesi
Proje Hakkında
Bu proje, Java Socket programlama kullanılarak geliştirilmiş basit bir HTTP web sunucusudur. Herhangi bir framework kullanmadan, sadece Java'nın standart kütüphaneleri ile oluşturulmuştur. Ağ programlamanın temellerini ve HTTP protokolünün çalışma prinsiplerini anlamak için geliştirilmiştir.
Özellikler

✅ Socket tabanlı HTTP sunucu implementasyonu
✅ UTF-8 karakter desteği (Türkçe karakterler dahil)
✅ HTTP/1.1 protokol desteği
✅ Dinamik HTML içerik üretimi
✅ Modern CSS stillendirmesi
✅ Detaylı konsol loglaması

Gereksinimler

Java JDK 8 veya üzeri
Modern web tarayıcısı (Chrome, Firefox, Safari, Edge)

Kurulum ve Çalıştırma
Derleme
bashjavac WebServer.java
Çalıştırma
bashjava WebServer
```

### Tarayıcıdan Erişim
Sunucu başlatıldıktan sonra tarayıcınızdan şu adrese gidin:
```
http://localhost:1989
Teknik Detaylar
Kullanılan Sınıflar

ServerSocket: Sunucu socket'i oluşturma ve bağlantı dinleme
Socket: İstemci bağlantılarını temsil etme
BufferedReader: İstemciden veri okuma
PrintWriter: İstemciye veri yazma
StandardCharsets: UTF-8 karakter kodlaması

Port Yapılandırması
javafinal int PORT = 1989;
Port numarasını değiştirmek için kodda PORT değişkenini düzenleyin.
Kod Yapısı
main Metodu

ServerSocket oluşturur ve 1989 portunda dinlemeye başlar
Gelen istemci bağlantılarını kabul eder
HTTP isteğini okur ve loglar
HTML içeriği oluşturur ve HTTP yanıtı gönderir
Try-with-resources ile güvenli kaynak yönetimi sağlar

buildHtmlContent Metodu

Öğrenci bilgilerini içeren HTML sayfası oluşturur
StringBuilder ile dinamik HTML yapısı kurar
Gömülü CSS stilleri ekler
Tamamlanmış HTML string'ini döndürür

HTTP Protokolü
Yanıt Yapısı
httpHTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Length: [içerik uzunluğu]

<!DOCTYPE html>
<html>
...
</html>
```

### Status Kodu
- **200 OK**: İstek başarıyla işlendi

### Headers
- **Content-Type**: İçerik tipi ve karakter kodlaması
- **Content-Length**: İçerik boyutu (byte cinsinden)

## Konsol Çıktıları

### Sunucu Başlatma
```
Sunucu 1989 portunda başlatıldı. Tarayıcıdan http://localhost:1989 adresine gidiniz.
```

### İstemci Bağlantısı
```
Yeni bir istemci bağlandı: 127.0.0.1
İstemci İsteği: GET / HTTP/1.1
Cevap gönderildi ve istemci bağlantısı kapatıldı.
Sorun Giderme
"Address already in use" Hatası
Sebep: Port başka bir program tarafından kullanılıyor.
Çözüm:
bash# Windows - Portu kullanan programı bulma
netstat -ano | findstr :1989

# Linux/macOS - Portu kullanan programı bulma
lsof -i :1989
Veya kodda farklı bir port numarası kullanın.
Türkçe Karakterler Bozuk
Sebep: Karakter kodlama sorunu.
Çözüm:

Dosyanın UTF-8 olarak kaydedildiğinden emin olun
IDE encoding ayarlarını kontrol edin

"Connection refused"
Sebep: Sunucu çalışmıyor.
Çözüm:

Sunucunun çalıştığından emin olun
Port numarasının doğru olduğunu kontrol edin

Geliştirme Fikirleri
Temel Geliştirmeler

 Route sistemi (/, /about, /contact)
 Statik dosya sunma (CSS, JS, resim)
 404 Not Found sayfası
 POST metodu desteği

İleri Düzey

 Multi-threading ile eşzamanlı bağlantı
 HTTPS desteği (SSL/TLS)
 Session yönetimi
 JSON API endpoint'leri

Güvenlik Notları
⚠️ ÖNEMLİ: Bu proje eğitim amaçlıdır ve üretim ortamında kullanılmamalıdır.
Eksik güvenlik özellikleri:

Input validation
HTTPS/SSL desteği
Authentication/Authorization
Rate limiting
XSS koruması

Sık Sorulan Sorular
S: Üretim ortamında kullanılabilir mi?
C: Hayır. Tomcat, Jetty veya Spring Boot gibi profesyonel çözümler kullanın.
S: Neden tek bir istemci aynı anda bağlanabiliyor?
C: Sunucu sıralı çalışır. Çoklu istemci için multi-threading gerekir.
S: HTTPS desteği var mı?
C: Hayır. HTTPS için SSL/TLS sertifikası ve SSLServerSocket gerekir.
Öğrenme Hedefleri
Bu proje ile kazanılan bilgiler:

Socket programlama temelleri
HTTP protokol yapısı ve çalışma prensibi
Client-Server mimarisi
Java I/O işlemleri
Karakter kodlama (UTF-8)
Try-with-resources kullanımı

Yazar
Fazıl Rahman Sabawoon
Öğrenci No: 5230505100
Bölüm: Yazılım Mühendisliği

Bu proje, ağ programlama ve socket iletişimi konularında pratik yapmak amacıyla geliştirilmiştir.
Lisans
Bu proje eğitim amaçlıdır ve özgürce kullanılabilir.
