<p align="center">
  <img src="https://img.shields.io/github/stars/Neeraj-Panchal/money-manager-api?style=social" alt="GitHub stars">
  <img src="https://img.shields.io/github/forks/Neeraj-Panchal/money-manager-api?style=social" alt="GitHub forks">
  <br>
  <h1>💰 MoneyManager - Backend API</h1>
  <h3>Scalable & Secure Personal Finance Management System 🚀</h3>
</p>

---

## 🌟 Overview

This is the robust backend for the **MoneyManager** application, designed to help users track their income, expenses, and savings efficiently. Built using the **Spring Boot** ecosystem, this API provides secure data handling and seamless integration for the frontend.

---

## 🎬 Project Demonstration

<p align="center">
  <a href="https://www.linkedin.com/posts/neeraj-panchal-5b6a85263_fullstack-springboot-reactjs-activity-7408585670748803072-abcd">
    <img src="https://img.shields.io/badge/Watch%20Full%20Demo-LinkedIn-0077B5?style=for-the-badge&logo=linkedin" alt="Watch Demo" />
  </a>
  <br>
  <i>Click to watch the MoneyManager application in action.</i>
</p>

---

## ✨ Features

- 🔐 **Secure Authentication**: Implemented **JWT (JSON Web Token)** with **Spring Security** for protected user access.
- 📊 **Finance Tracking**: Endpoints to manage Income, Expenses, and Categories.
- 📈 **Dashboard Analytics**: Optimized queries to fetch real-time dashboard data for user insights.
- 📂 **Profile Management**: User registration and profile handling with secure password encryption.
- 🛠️ **API Documentation**: Structured endpoints designed for easy integration with React/Next.js frontends.

---

## 🛠️ Tech Stack

- **Language**: Java
- **Framework**: Spring Boot, Spring Security
- **Authentication**: JWT (JSON Web Tokens)
- **Database**: MySQL
- **Testing Tools**: Postman, Swagger

---

## 🚀 API Testing & Documentation

The API has been rigorously tested using **Postman**. Below is a look at the comprehensive collection covering User Registration, Login, and Finance Management.

<p align="center">
  <img src="https://github.com/Neeraj-Panchal/money-manager-api/blob/main/MM-testing.png" width="800" alt="Postman Testing API Network" />
</p>

---

## 💻 Installation

```bash
# Clone the repository
git clone [https://github.com/Neeraj-Panchal/money-manager-api.git](https://github.com/Neeraj-Panchal/money-manager-api.git)

# Configure MySQL in src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/money_manager
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

# Run the application
mvn spring-boot:run
