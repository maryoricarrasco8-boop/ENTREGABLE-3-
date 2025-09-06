# Guía de Ejecución (IntelliJ + Maven + MongoDB)

## Requisitos
- JDK 17
- Maven 3.9+
- MongoDB 6+ (o Docker)
- IntelliJ IDEA / VS Code
- Postman (opcional)

## 1) Ubicación de módulos
Copia las carpetas `modules/client-ms` y `modules/transactions-ms` dentro del monorepo `banking-manager/`.

Estructura esperada:
```
banking-manager/
 ├─ client-ms/
 ├─ transactions-ms/
 ├─ pom.xml (root)
```
Abre `banking-manager/pom.xml` y agrega:
```xml
<modules>
  <module>client-ms</module>
  <module>transactions-ms</module>
</modules>
```

## 2) MongoDB
**Opción A (Docker):**
```bash
cd client-ms
docker compose up -d
```
**Opción B (Local):**
Instala y corre MongoDB (puerto 27017).

## 3) Levantar servicios
En terminal o IntelliJ:
```bash
mvn spring-boot:run -pl client-ms
mvn spring-boot:run -pl transactions-ms
```

## 4) Swagger UI
- client-ms → http://localhost:8081/swagger-ui.html
- transactions-ms → http://localhost:8083/swagger-ui.html

## 5) Probar con Postman
Importa estas colecciones (están en la raíz de este paquete):
- `ClientMS_Full_Postman.json`
- `Transactions_Postman_Collection.json`

Setea `baseUrl` según cada servicio y ejecuta en orden.
