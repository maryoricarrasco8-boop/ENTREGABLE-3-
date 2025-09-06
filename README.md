# PROYECTO III — ENTREGABLE 3 (Final)

Este paquete contiene TODO lo requerido por el Entregable 3:
- **Microservicio `client-ms`** (CRUD + búsqueda por documento).
- **Microservicio `transactions-ms`** (depósito, retiro, transferencia, historial) con MongoDB y WebFlux.
- **Contrato OpenAPI** para ambos servicios (YAML).
- **Diagramas** (componentes y secuencias) en formato Mermaid.
- **Colecciones Postman** con variables y tests.
- **Docker Compose** para levantar MongoDB.
- **Guía Paso a Paso** para clonar, compilar, correr y probar.

## Estructura
```
Entregable3_Final/
├─ docs/
│  ├─ README_Ejecucion.md
│  ├─ openapi-client.yaml
│  ├─ openapi-transactions.yaml
│  └─ diagramas.md
└─ modules/
   ├─ client-ms/           (código fuente completo)
   └─ transactions-ms/     (código fuente completo)
```

## Resumen de Endpoints

### client-ms (puerto 8081)
- POST `/clients` — crear cliente
- GET `/clients/{id}` — obtener por ID
- GET `/clients/document/{documentNumber}` — obtener por DNI/CE
- GET `/clients?lastName=&email=` — listar/filtrar
- PUT `/clients/{id}` — actualizar
- DELETE `/clients/{id}` — eliminar

### transactions-ms (puerto 8083)
- POST `/transacciones/deposito`
- POST `/transacciones/retiro`
- POST `/transacciones/transferencia`
- GET  `/transacciones/historial?accountId=&from=&to=`

> **Nota**: En entorno académico, la validación de saldo puede ser mock o integrada contra `account-ms` vía `WebClient`. En esta entrega incluimos el **hook** con `WebClient` y una **validación simple** (se puede adaptar a su `account-ms`).

## Evidencias solicitadas (incluidas como guía)
- Swagger UI accesible.
- Respuestas 201 (depósito, retiro, transferencia).
- Historial 200 con registros.
- Colecciones Postman para reproducibilidad.

Para pasos de ejecución, ver `docs/README_Ejecucion.md`.
