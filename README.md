# Examen Systèmes Distribués - Conference Management System

This project is a microservices-based application for managing **Conferences** and **Keynotes**, developed as part of the Distributed Systems Exam. It features a modern architecture using **Spring Cloud**, **Docker**, and **Angular**, secured with **Keycloak**.

## 🚀 Architecture

The system is composed of the following microservices:

| Service | Port | Description |
| :--- | :--- | :--- |
| **Discovery Service** | `8761` | Eureka Server for service registration and discovery. |
| **Config Service** | `8888` | Centralized configuration server. |
| **Gateway Service** | `8888` | Spring Cloud Gateway acting as the single entry point. |
| **Keynote Service** | `8081` | Manages Keynote speakers (CRUD). |
| **Conference Service** | `8082` | Manages Conferences and Reviews. Uses OpenFeign to communicate with Keynote Service. |
| **Frontend App** | `4200` | Angular web application for the user interface. |
| **Keycloak** | `8080` | IAM Provider for OAuth2/OIDC authentication. |

## 🛠️ Technologies

-   **Backend**: Java 17, Spring Boot 3.2.2, Spring Cloud 2023.0.0 (Eureka, Gateway, Config, OpenFeign).
-   **Frontend**: Angular 17.
-   **Database**: H2 (In-memory) for microservices.
-   **Security**: Keycloak (OAuth2 / OIDC).
-   **Resilience**: Resilience4J (Circuit Breaker).
-   **Containerization**: Docker & Docker Compose.

## 📦 Prerequisites

-   **Docker** and **Docker Compose** installed.
-   **Java 17** (if running locally without Docker).
-   **Node.js & NPM** (for Frontend development).

## 🏃‍♂️ How to Run

The easiest way to run the entire system is using Docker Compose.

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/basic-kali-box/el-mehdi-benlekhal.git
    cd el-mehdi-benlekhal
    ```

2.  **Build the microservices** (Optional if using pre-built images, but recommended for first run):
    ```bash
    ./mvnw clean package -DskipTests
    ```

3.  **Start the infrastructure**:
    ```bash
    docker-compose up -d --build
    ```

4.  **Access the services**:
    -   **Gateway**: [http://localhost:8888](http://localhost:8888)
    -   **Eureka Dashboard**: [http://localhost:8761](http://localhost:8761)
    -   **Keycloak Console**: [http://localhost:8080](http://localhost:8080) (Admin: `admin` / `admin`)

## 🔐 Security

The application uses **Keycloak** for authentication.
-   **Admin Console**: `http://localhost:8080`
-   **Credentials**: `admin` / `admin`
-   **Realm**: Create a realm named `conference-realm`.
-   **Client**: Create a client `conference-app` for the Angular frontend.

## 📡 API Endpoints

### Keynote Service
-   `GET /keynotes`: List all keynotes.
-   `GET /keynotes/{id}`: Get keynote details.
-   `POST /keynotes`: Create a new keynote.

### Conference Service
-   `GET /conferences`: List all conferences.
-   `GET /conferences/{id}`: Get conference details (includes Keynote info).
-   `POST /conferences`: Create a new conference.
-   `POST /conferences/{id}/reviews`: Add a review to a conference.

## 🧪 Testing

You can test the APIs using Postman or curl via the Gateway:

```bash
# Get all conferences
curl http://localhost:8888/conference-service/conferences
```
