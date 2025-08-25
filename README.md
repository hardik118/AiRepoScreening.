# AiRepoScreening

## Overview

**AiRepoScreening** is an intent-based, scalable repository evaluation system. Designed to automate and streamline the assessment of repositories for specific use cases, it currently focuses on teacher professionals and classroom environments. The system leverages a robust microservices architecture and modern messaging technologies to ensure reliability, flexibility, and high throughput.

## Key Features

- **Intent-Based Evaluation:** Evaluations are triggered and processed based on user-defined intents, allowing tailored workflows for diverse scenarios (e.g., classroom screening, teacher portfolio review).
- **Scalable Architecture:** Built to handle large volumes of evaluation requests efficiently, with seamless horizontal scaling.
- **Kafka Integration:** Utilizes Apache Kafka for high-throughput, reliable messaging between the main service and evaluation microservices.
- **Microservice Design:** The evaluation logic is delegated to a dedicated microservice ([EvaluationMicroService](https://github.com/hardik118/EvaluationMicroService)), enabling modular development and easy extension.
- **Automated Screening:** Reduces manual intervention in repository assessment, saving time for educators and administrators.
- **Extensible:** Easily adapts to new intents, evaluation criteria, and user groups.

## Architecture

- **AiRepoScreening (Main Service):** Orchestrates intent handling, manages repository screening requests, and interfaces with Kafka for event-driven communication.
- **EvaluationMicroService (Microservice):** Processes evaluation requests, applies assessment logic, and returns results to the main service.

## Technologies Used

- **Kafka:** For event-driven, asynchronous communication and decoupled workflow management.
- **Java (EvaluationMicroService):** Provides the core evaluation logic.
- **Node.js/Python (AiRepoScreening):** Specify as per your implementation.
- **Docker:** Recommended for deployment and scalability.

## Current Use Case

- **Teacher Professionals & Classrooms:** The system is actively being used to evaluate repositories related to teacher portfolios and classroom resources, supporting educational institutions in their digital transformation.

## Getting Started

### Prerequisites

- Docker
- Java (for EvaluationMicroService)
- Node.js or Python (for AiRepoScreening main service)
- Kafka (locally or via cloud provider)

### Setup Instructions

1. **Clone the repositories:**
   ```bash
   git clone https://github.com/hardik118/AiRepoScreening.git
   git clone https://github.com/hardik118/EvaluationMicroService.git
   ```

2. **Set up Kafka:**
   - Install and run Kafka locally, or configure access to a cloud Kafka instance.

3. **Start EvaluationMicroService:**
   - Build and run the microservice (`mvn install`, `java -jar ...`, or via Docker).

4. **Configure AiRepoScreening:**
   - Set microservice endpoints and Kafka broker settings in the configuration.

5. **Run AiRepoScreening:**
   - Start the main service application.

### Usage

- Submit evaluation requests with the desired intent and repository details.
- The system routes requests via Kafka, processes them using EvaluationMicroService, and returns the results.

## Repository Links

- [AiRepoScreening (this repo)](https://github.com/hardik118/AiRepoScreening)
- [EvaluationMicroService](https://github.com/hardik118/EvaluationMicroService)

## Contributing

Open to collaboration! Please submit issues, feature requests, or pull requests to help improve the system.

## License

Specify license here (MIT, Apache, etc.)

## Contact

Questions or collaboration inquiries? Contact [@hardik118](https://github.com/hardik118).
