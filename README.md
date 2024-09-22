# Bacen Sandbox

Bacen Sandbox is a project designed to simulate various operations related to the Central Bank of Brazil (BACEN). It is primarily focused on studying integrations with BACEN and the use of RabbitMQ for messaging between microservices. The project is divided into three modules:

- `ms-core`: The core module responsible for common configurations and utilities.
- `ms-polling`: A module that simulates polling operations to BACEN to fetch updates or data.
- `ms-send`: A module responsible for sending processed information to RabbitMQ.

## Table of Contents
1. [Getting Started](#getting-started)
2. [Modules Overview](#modules-overview)
    - [ms-core](#ms-core)
    - [ms-polling](#ms-polling)
    - [ms-send](#ms-send)
3. [Configuration](#configuration)
4. [Running the Project](#running-the-project)
5. [Contributing](#contributing)
6. [License](#license)

## Getting Started

### Prerequisites

To get started with the Bacen Sandbox project, make sure you have the following prerequisites:

- Java 17 or later
- Gradle 7.x
- Docker (for RabbitMQ)
- A basic understanding of Spring Boot, RabbitMQ, and BACEN operations

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/bacen-sandbox.git
    ```
2. Navigate to the project directory:
    ```bash
    cd bacen-sandbox
    ```
3. Build the project using Gradle:
    ```bash
    ./gradlew build
    ```

## Modules Overview

### ms-core

The `ms-core` module contains shared configurations and utilities used by other modules. It provides the basic setup for logging, exception handling, and common properties.

#### Key Features
- Centralized configuration management.
- Common utilities for the project.

### ms-polling

The `ms-polling` module is responsible for simulating polling operations with BACEN. It uses scheduled tasks to periodically fetch data from a simulated BACEN API and process the information accordingly.

#### Key Features
- Scheduled polling using Spring's `@Scheduled` annotation.
- Simulated API integration with BACEN.
- Data transformation and validation.

### ms-send

The `ms-send` module handles the messaging operations using RabbitMQ. It sends the processed data from `ms-polling` to a RabbitMQ exchange for further processing or storage.

#### Key Features
- Integration with RabbitMQ.
- Message publishing and queue management.
- Error handling and retries.

## Configuration

### RabbitMQ

The project requires a running instance of RabbitMQ. You can start one using Docker:

```bash
docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
