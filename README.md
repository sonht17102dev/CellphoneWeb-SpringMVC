# CellphoneWeb-SpringMVC

Đây là trang web bán hàng sử dụng công nghệ Spring framework.

Project được phát triển trên phiên bản Eclipse developersEclipse IDE 2022-09. Vui lòng cài đặt phiên bản tomcat 9.0.68. 
- Xem hướng dẫn tại đây : https://huongdanjava.com/vi/cai-dat-tomcat-trong-eclipse.html

Database được tạo bằng MS SQL Server Vui lòng cài đặt phiên bản Microsoft SQL Server 2019 (RTM-GDR) (KB5021125) - 15.0.2101.7 (X64). 
- Xem hướng dẫn tại đây : https://quantrimang.com/cong-nghe/cai-dat-sql-server-2019-159201

File sql được đính kèm trong project tên là ShoppingDBASM4.sql.

A. Mô tả ứng dụng

Bước đầu tiên là thiết kế cơ sở dữ liệu của project.

A.Lưu ý về lỗi kết nối cơ sở dữ liệu

Trên console của Eclipse/IntelliJ IDEA có lỗi sau:
javax.servlet.jsp.JspException: Unable to get connection, DataSource invalid: "java.sql.SQLException: Cannot create PoolableConnectionFactory (The TCP/IP connection to the host DESKTOP-JF0IAR2, port 1433 has failed. Error: "Connect timed out. Verify the connection properties. Make sure that an instance of SQL Server is running on the host and accepting TCP/IP connections at the port. Make sure that TCP connections to the port are not blocked by a firewall.".)"

Gợi ý xử lý lỗi: Lỗi này do cấu hình của sql server chưa mở port 1433. Tùy version của SQL server mà có các cách xử lí khác nhau.

Tham khảo link sau: https://docs.microsoft.com/en-us/sql/database-engine/configure-windows/configure-a-server-to-listen-on-a-specific-tcp-port?view=sql-server-ver16

B. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:
Caused by: com.microsoft.sqlserver.jdbc.SQLServerException: Login failed for user 'sa'. ClientConnectionId:4a1fb7ab-3f5e-4808-a645-466752c1f4b0

Gợi ý xử lý lỗi: Lỗi này có thể do password của account sa bị sai hoặc chưa enable sa account. Bạn cần kiểm tra source code đã dùng đúng password của sa chưa.

Để enable sa account, học viên tham khảo link sau: 
https://docs.microsoft.com/en-us/sql/database-engine/configure-windows/change-server-authentication-mode?view=sql-server-ver16.

C. Lưu ý về lỗi khi start run project web

1. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:

Caused by: java.lang.IllegalArgumentException: More than one fragment with the name [spring_web] was found. 
This is not legal with relative ordering. See section 8.2.2 2c of the Servlet specification for details. Consider using absolute ordering.

Gợi ý xử lý lỗi: Học viên cần thêm <absolute-ordering /> tag vào file web.xml, vào dưới  <display-name> tag

2. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:

Caused by: java.lang.NoClassDefFoundError: org/apache/commons/logging/Log

at java.base/java.lang.Class.getDeclaredFields0(Native Method)

Gợi ý xử lý lỗi: cần add thư viện commons-logging phù hợp vào maven.

3. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:

java.lang.ClassNotFoundException: javax.servlet.http.HttpServlet

at org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1449)

at org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1257)

Gợi ý xử lý lỗi: Lỗi này do ở runtime, không tim thấy class javax.servlet.http.HttpServlet, 
có thể do bạn đang dùng version của Tomcat và Spring không tương thích. 
Trường hợp này bạn cần dùng Tomcat 8 hoặc Tomcat 9. JDK có thể dùng JDK 11

Các tính năng chính của chương trình được giới thiệu trong video demo tại đây : https://www.youtube.com/watch?v=IhExq2VoQUM

Cảm ơn đã theo dõi & follow để xem nhiều source code hơn.
