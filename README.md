Web Sunucusu Projesi - Java Socket Programlama
📋 İçindekiler

Proje Hakkında
Özellikler
Gereksinimler
Kurulum
Kullanım
Teknik Detaylar
Kod Yapısı
HTTP Protokolü
Örnek Çıktılar
Sorun Giderme
Geliştirme Fikirleri
Sık Sorulan Sorular
Lisans

🎯 Proje Hakkında
Bu proje, Java programlama dilinde socket programlama kullanılarak sıfırdan geliştirilmiş bir HTTP web sunucusudur. Herhangi bir üçüncü parti kütüphane veya framework kullanmadan, sadece Java'nın standart kütüphaneleri ile düşük seviyeli ağ programlama yapılarak oluşturulmuştur.
Proje, ağ programlamanın temellerini anlamak, HTTP protokolünün nasıl çalıştığını öğrenmek ve client-server mimarisini kavramak için mükemmel bir öğrenme kaynağıdır.
Projenin Amacı

Socket programlama temellerini öğrenmek
HTTP protokolünün çalışma prensiplerini anlamak
Server-Client iletişimini kavramak
Java I/O işlemlerinde deneyim kazanmak
Ağ programlama konusunda pratik yapmak

✨ Özellikler
Ana Özellikler

✅ Socket Tabanlı HTTP Sunucu: Java ServerSocket ve Socket sınıfları kullanılarak geliştirilmiştir
✅ UTF-8 Karakter Desteği: Türkçe karakterler dahil tüm Unicode karakterleri desteklenir
✅ HTTP/1.1 Protokol Desteği: Standart HTTP protokolü ile uyumludur
✅ Dinamik HTML İçerik: Java kodundan dinamik olarak HTML sayfası üretilir
✅ CSS Stillendirme: Modern ve responsive tasarım
✅ Otomatik Bağlantı Yönetimi: Try-with-resources ile güvenli kaynak yönetimi
✅ Konsol Loglaması: Detaylı sunucu aktivite kayıtları

Teknik Özellikler

Çoklu istemci bağlantı desteği (sıralı olarak)
Otomatik karakter kodlama yönetimi
Content-Length header hesaplaması
Exception handling ile hata yönetimi
Güvenli kaynak kapatma (try-with-resources)

💻 Gereksinimler
Yazılım Gereksinimleri

Java Development Kit (JDK): 8 veya üzeri

JDK 11 veya JDK 17 önerilir
Oracle JDK veya OpenJDK kullanılabilir



Sistem Gereksinimleri

İşletim Sistemi: Windows, macOS, Linux (herhangi bir Java destekleyen platform)
RAM: Minimum 512 MB (1 GB önerilir)
Disk Alanı: 50 MB

Opsiyonel Araçlar

Java IDE (IntelliJ IDEA, Eclipse, NetBeans, VS Code)
Git (versiyon kontrolü için)
Modern web tarayıcısı (Chrome, Firefox, Safari, Edge)

🚀 Kurulum
Adım 1: Projeyi İndirin
bash# Git ile klonlayın (eğer repository mevcutsa)
git clone <repository-url>
cd web-sunucu-projesi
veya WebServer.java dosyasını doğrudan indirin.
Adım 2: Java Kurulumunu Kontrol Edin
bash# Java versiyonunu kontrol edin
java -version

# Java derleyicisini kontrol edin
javac -version
Adım 3: Komut Satırından Derleme
bash# Tek dosya derleme
javac WebServer.java

# Derleme sonrası WebServer.class dosyası oluşacaktır
Adım 4: IDE Kullanarak Derleme
IntelliJ IDEA:

Yeni Java projesi oluşturun
WebServer.java dosyasını src klasörüne ekleyin
Build > Build Project seçeneğini kullanın

Eclipse:

Yeni Java projesi oluşturun
WebServer.java dosyasını projeye ekleyin
Otomatik olarak derlenecektir

VS Code:

Java Extension Pack'i yükleyin
Klasörü açın
WebServer.java dosyasını açın ve kaydedin

📖 Kullanım
Sunucuyu Başlatma
Komut Satırından:
bashjava WebServer
```

#### IDE'den:
1. `WebServer.java` dosyasını açın
2. `main` metodunun yanındaki yeşil çalıştırma butonuna tıklayın
3. veya `Run` > `Run 'WebServer'` seçeneğini kullanın

### Beklenen Konsol Çıktısı
```
Sunucu 1989 portunda başlatıldı. Tarayıcıdan http://localhost:1989 adresine gidiniz.
```

### Web Tarayıcısından Erişim

1. Web tarayıcınızı açın (Chrome, Firefox, Safari, Edge)
2. Adres çubuğuna aşağıdaki URL'yi yazın:
```
   http://localhost:1989

Enter tuşuna basın
Kişisel bilgileri içeren HTML sayfasını göreceksiniz

Sunucuyu Durdurma

Komut Satırı: Ctrl + C (Windows/Linux) veya Cmd + C (macOS)
IDE: Stop butonuna tıklayın (kırmızı kare ikonu)

🔧 Teknik Detaylar
Kullanılan Java Sınıfları
SınıfPaketKullanım AmacıServerSocketjava.netSunucu socket'i oluşturma ve istemci bağlantılarını dinlemeSocketjava.netİstemci bağlantılarını temsil etmeBufferedReaderjava.ioİstemciden gelen verileri okumaInputStreamReaderjava.ioByte stream'i karakter stream'ine dönüştürmePrintWriterjava.ioİstemciye veri yazmaStandardCharsetsjava.nio.charsetUTF-8 karakter kodlaması
Port Yapılandırması
javafinal int PORT = 1989;

Port Numarası: 1989
Neden bu port?: 1024-49151 arası kayıtlı kullanıcı portları aralığında
Port Değiştirme: Kodda PORT değişkenini değiştirerek farklı bir port kullanılabilir

Karakter Kodlama
Proje tamamen UTF-8 karakter kodlaması kullanır:
javaStandardCharsets.UTF_8
Bu sayede:

Türkçe karakterler (ç, ğ, ı, ö, ş, ü) düzgün görüntülenir
Uluslararası karakterler desteklenir
Modern web standartlarına uyum sağlanır

📚 Kod Yapısı
main Metodu
javapublic static void main(String[] args)
Görevleri:

ServerSocket oluşturur ve 1989 portunda dinlemeye başlar
Sonsuz döngü ile sürekli çalışır
accept() metodu ile gelen istemci bağlantılarını kabul eder
Her bağlantı için:

İstemci IP adresini loglar
HTTP isteğini okur
HTML içeriği oluşturur
HTTP yanıtı gönderir
Bağlantıyı kapatır


Hata durumlarını yönetir

Try-with-resources Kullanımı:
javatry (ServerSocket serverSocket = new ServerSocket(PORT)) {
    // Sunucu kodu
}
Bu yapı sayesinde kaynaklar otomatik olarak kapatılır.
buildHtmlContent Metodu
javaprivate static String buildHtmlContent()
```

**Görevleri:**
1. Öğrenci bilgilerini tanımlar (ad-soyad, numara, biyografi)
2. `StringBuilder` ile HTML yapısını oluşturur
3. CSS stilleri ekler
4. Tamamlanmış HTML string'ini döndürür

**HTML Yapısı:**
- DOCTYPE ve HTML5 yapısı
- Meta charset bilgisi
- Başlık (title)
- Gömülü CSS stilleri
- Responsive container yapısı
- Başlıklar ve içerik paragrafları

## 🌐 HTTP Protokolü

### HTTP İstek Akışı

1. **İstemci Bağlantısı**: Tarayıcı sunucuya TCP bağlantısı kurar
2. **HTTP İsteği**: Tarayıcı HTTP GET isteği gönderir
```
   GET / HTTP/1.1
   Host: localhost:1989
   ...

İstek Okuma: Sunucu isteği okur ve loglar
İçerik Üretimi: HTML içeriği dinamik olarak oluşturulur
HTTP Yanıtı: Sunucu HTTP yanıtı gönderir
Bağlantı Kapatma: İstemci bağlantısı kapatılır

HTTP Yanıt Yapısı
httpHTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Length: 1234

<!DOCTYPE html>
<html>
...
</html>
HTTP Status Kodu:

200 OK: İstek başarılı

HTTP Headers:

Content-Type: İçerik tipi ve karakter kodlaması
Content-Length: İçerik uzunluğu (byte cinsinden)

Content-Length Hesaplama
javaint contentLength = htmlContent.getBytes(StandardCharsets.UTF_8).length;
```

Bu hesaplama önemlidir çünkü:
- Tarayıcıya ne kadar veri beklemesi gerektiğini bildirir
- UTF-8'de bir karakter 1-4 byte arasında olabilir
- Türkçe karakterler için doğru byte sayısını verir

## 📊 Örnek Çıktılar

### Konsol Çıktısı (Sunucu Başlatma)
```
Sunucu 1989 portunda başlatıldı. Tarayıcıdan http://localhost:1989 adresine gidiniz.
```

### Konsol Çıktısı (İstemci Bağlantısı)
```
Yeni bir istemci bağlandı: 127.0.0.1
İstemci İsteği: GET / HTTP/1.1
Cevap gönderildi ve istemci bağlantısı kapatıldı.
```

### Konsol Çıktısı (Hata Durumu)
```
İstemci bağlantısı kabul edilirken hata oluştu: Connection reset
```

veya
```
Sunucu 1989 portunda başlatılamadı: Address already in use
Tarayıcı Görünümü
Tarayıcıda şu içerik görüntülenir:

Büyük mavi başlık: Öğrenci adı-soyadı
Alt başlık: Öğrenci numarası
Yatay çizgi
Biyografi metni
Temiz ve modern tasarım
Beyaz arka planlı container
Gölgeli kutu efekti

🔍 Sorun Giderme
Problem: "Address already in use" Hatası
Sebep: 1989 portu başka bir program tarafından kullanılıyor.
Çözüm 1: Portu kullanan programı kapatın
bash# Windows
netstat -ano | findstr :1989
taskkill /PID <PID> /F

# Linux/macOS
lsof -i :1989
kill -9 <PID>
Çözüm 2: Kodda farklı bir port kullanın
javafinal int PORT = 8080; // Veya başka bir port
Problem: "Connection refused" Hatası
Sebep: Sunucu çalışmıyor.
Çözüm:

Sunucunun çalıştığından emin olun
Konsol çıktısını kontrol edin
Port numarasının doğru olduğunu kontrol edin

Problem: Türkçe Karakterler Bozuk Görünüyor
Sebep: Karakter kodlama sorunu.
Çözüm:

Dosyanın UTF-8 olarak kaydedildiğinden emin olun
IDE encoding ayarlarını kontrol edin
StandardCharsets.UTF_8 kullanıldığını doğrulayın

Problem: Sayfa Yüklenmiyor
Sebep: Firewall veya güvenlik yazılımı engelliyor olabilir.
Çözüm:

Firewall ayarlarını kontrol edin
Antivirüs yazılımını geçici olarak devre dışı bırakın
localhost yerine 127.0.0.1 deneyin

Problem: Çok Yavaş Yanıt
Sebep: Sıralı bağlantı işleme.
Çözüm:
Bu normal bir davranıştır. Üretim ortamı için multi-threading eklenmelidir.
💡 Geliştirme Fikirleri
Seviye 1: Temel Geliştirmeler

 Farklı URL yolları için route sistemi (/, /about, /contact)
 Statik dosya sunma (CSS, JavaScript, resimler)
 404 Not Found sayfası
 Favicon desteği
 Query string parametrelerini okuma

Seviye 2: Orta Düzey Geliştirmeler

 Multi-threading ile eşzamanlı bağlantı desteği
 Thread pool kullanımı
 POST metodu desteği
 Form verilerini işleme
 Cookie desteği
 Session yönetimi
 JSON API endpoint'leri

Seviye 3: İleri Düzey Geliştirmeler

 HTTPS desteği (SSL/TLS)
 Gzip sıkıştırma
 Caching mekanizması
 WebSocket desteği
 Rate limiting
 Request/Response logging
 Configuration dosyası (properties/yaml)
 Database entegrasyonu

Seviye 4: Profesyonel Özellikler

 REST API framework'ü
 Authentication/Authorization
 CORS desteği
 Request validation
 Error handling middleware
 Monitoring ve metrics
 Docker containerization
 Load balancing

❓ Sık Sorulan Sorular
S: Bu sunucu üretim ortamında kullanılabilir mi?
C: Hayır. Bu proje eğitim amaçlıdır. Üretim ortamı için Tomcat, Jetty, Spring Boot gibi profesyonel çözümler kullanılmalıdır.
S: Neden sadece tek bir istemci aynı anda bağlanabiliyor?
C: Sunucu sıralı (sequential) çalışır. Çoklu istemci desteği için multi-threading eklenmelidir.
S: Port numarasını nasıl değiştirebilirim?
C: PORT değişkeninin değerini değiştirin:
javafinal int PORT = 8080; // Yeni port numarası
S: HTTPS desteği var mı?
C: Hayır. HTTPS için SSL/TLS sertifikası ve SSLServerSocket kullanılması gerekir.
S: Statik dosyaları (CSS, JS, resim) nasıl sunabilirim?
C: URL'yi parse edip dosya sisteminden okuma yapacak kod eklemeniz gerekir. Bu projede sadece inline HTML sunulmaktadır.
S: Başka portlardan erişim sağlayabilir miyim?
C: Evet, farklı port numaraları kullanabilirsiniz. Ancak 1024'ün altındaki portlar için admin yetkisi gerekebilir.
S: Exception handling yeterli mi?
C: Temel hatalar yakalanıyor ancak üretim ortamı için daha kapsamlı error handling gerekir.
📝 Notlar
Güvenlik Uyarıları
⚠️ ÖNEMLİ GÜVENLİK NOTLARI:

Üretim Kullanımı: Bu kod üretim ortamında kullanılmamalıdır
Input Validation: Kullanıcı girişleri doğrulanmamaktadır
SQL Injection: Database kullanımında dikkatli olunmalıdır
XSS Saldırıları: HTML içeriği sanitize edilmemektedir
DoS Saldırıları: Rate limiting bulunmamaktadır
HTTPS: Şifreli bağlantı yoktur
Authentication: Kimlik doğrulama mekanizması yoktur

Performans Notları

Sıralı bağlantı işleme nedeniyle aynı anda tek istemci desteklenir
Her bağlantı için yeni HTML içeriği oluşturulur (caching yok)
Büyük dosyalar için bellek problemi olabilir
Thread pool kullanılmamaktadır

Öğrenme Kaynakları
Bu projeyi geliştirmek için faydalı kaynaklar:

Oracle Java Documentation
Java Network Programming
HTTP Protocol RFC
Socket Programming Tutorial

👨‍💻 Yazar
Fazıl Rahman Sabawoon
Öğrenci No: 5230505100
Bölüm: Yazılım Mühendisliği
Bu proje, ağ programlama ve socket iletişimi konularında pratik yapmak amacıyla geliştirilmiştir.
📄 Lisans
Bu proje eğitim amaçlıdır ve özgürce kullanılabilir.

Son Güncelleme: 2025
Java Version: JDK 8+
Proje Durumu: Eğitim Projesi
