# 🎟 Ticket Management System

## 📌 Overview

A backend system for managing user tickets and support requests using **Java, JDBC, and MySQL**.

> ✅ This project demonstrates core backend development concepts including database interaction, DAO pattern, CRUD operations, and relational data handling using JOIN.

---

## 🚀 Features

* User creation and management
* Ticket creation and assignment
* Fetch all tickets with assigned user names (using JOIN)
* Fetch ticket by ID
* Update ticket status
* Delete users and tickets
* Database connectivity using JDBC

---

## 🛠 Tech Stack

* Java
* JDBC
* MySQL

---

## ⚙️ Key Implementations

* DAO (Data Access Object) pattern for clean architecture
* PreparedStatement to prevent SQL injection
* JOIN queries to fetch relational data (user name with tickets)
* Proper resource handling (Connection, Statement, ResultSet)
* Encapsulation using model classes (User, Ticket)

---

## 🎯 Learning Outcomes

* Implemented complete CRUD operations using JDBC
* Understood relational database design (Primary Key, Foreign Key)
* Learned JOIN queries for combining data across tables
* Built clean backend structure using DAO pattern
* Strengthened core backend development fundamentals

---

## ▶️ How to Run

1. Clone the repository
2. Create MySQL database (e.g., `ticket_management_system`)
3. Update DB credentials in `DBConnection.java`
4. Run `Main.java`

---

⭐ *This project serves as a foundation for building scalable backend systems using Spring Boot* 🚀