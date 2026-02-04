# 📦 Inventory Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/PostgreSQL-005C84?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

*A robust inventory management system built with Hibernate ORM and PostgreSQL*

[Features](#-features) • [Getting Started](#-getting-started) • [Usage](#-usage) • [Database Schema](#-database-schema) • [Contributing](#-contributing)

</div>

---

## 📋 Overview

This project is a **console-based Inventory Management System** that demonstrates the implementation of **Hibernate ORM** for database operations. It provides a complete CRUD interface for managing products, categories, and suppliers in an inventory database.

### 🎯 Purpose

Built as a learning project to practice and demonstrate:
- Hibernate ORM fundamentals
- JPA annotations and entity relationships
- Database transaction management
- CRUD operations with persistent entities
- Many-to-One relationship mappings

---

## ✨ Features

### 📦 Product Management
- ✅ Create new products with category and supplier associations
- ✅ Retrieve product details by ID
- ✅ View all products in inventory
- ✅ Delete products from inventory
- ✅ Track stock levels

### 🏷️ Category Management
- ✅ Create product categories
- ✅ Retrieve category information
- ✅ Delete categories
- ✅ Query categories by name

### 🚚 Supplier Management
- ✅ Register new suppliers
- ✅ View supplier details
- ✅ Delete supplier records
- ✅ Search suppliers by name

---

## 🛠️ Tech Stack

| Technology                  | Purpose |
|-----------------------------|---------|
| **Java 17+**                | Core programming language |
| **Hibernate 6.x**           | ORM framework |
| **PostgreSQL**              | Relational database |
| **Jakarta Persistence API** | JPA specification |
| **Maven**                   | Dependency management |

---

## 🚀 Getting Started

### Prerequisites

Before running this project, ensure you have:

- ☕ **Java Development Kit (JDK) 17 or higher**
- 🗄️ **PostgreSQL Server**
- 📦 **Maven 3.6+**
- 💻 **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/umairdev010/Simple_Inventory_System.git
   cd Simple_Inventory_System
   ```

2. **Set up PostgreSQL Database**
   ```sql
   CREATE DATABASE inventory_db;
   USE inventory_db;
   ```

3. **Configure Database Connection**

   Update `src/main/resources/hibernate.cfg.xml`:
   ```xml
   <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/inventory_db</property>
   <property name="hibernate.connection.username">your_username</property>
   <property name="hibernate.connection.password">your_password</property>
   ```

4. **Build the Project**
   ```bash
   mvn clean install
   ```

5. **Run the Application**
   ```bash
   mvn exec:java -Dexec.mainClass="org.practice.umair.App"
   ```

---

## 💡 Usage

### Main Menu Interface

```
WELCOME TO INVENTORY MANAGEMENT SYSTEM.

PLEASE ENTER A NUMBER WHICH THING YOU HAVE TO MANAGE:
1. MANAGE PRODUCTS
2. MANAGE SUPPLIER
3. MANAGE CATEGORIES
```

### Example Workflow

#### Creating a New Product

1. Select option `1` (Manage Products)
2. Select option `1` (Create Product)
3. Enter product details:
    - Product name
    - Available stock
    - Category name
    - Supplier name

```bash
ENTER THE NAME OF PRODUCT: Laptop
ENTER THE AVAILABLE STOCK: 50
ENTER ITS CATEGORY NAME: Electronics
ENTER THE NAME OF SUPPLIER: Tech Supplies Inc.
```

---
### Tables

#### `categories_inventory`
| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key (Auto-increment) |
| name | VARCHAR | Category name |
| description | TEXT | Category description |

#### `suppliers_inventory`
| Column | Type | Description |
|--------|------|-------------|
| supplier_id | INT | Primary Key (Auto-increment) |
| name | VARCHAR | Supplier name |
| phone | VARCHAR | Contact number |

#### `products_inventory`
| Column | Type | Description |
|--------|------|-------------|
| product_id | INT | Primary Key (Auto-increment) |
| name | VARCHAR | Product name |
| category_id | INT | Foreign Key → categories |
| supplier_id | INT | Foreign Key → suppliers |
| stock | INT | Available quantity |

---

## 📁 Project Structure

```
inventory-management-hibernate/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/practice/
│   │   │       ├── entities/
│   │   │       │   ├── Category.java
│   │   │       │   ├── Product.java
│   │   │       │   └── Supplier.java
│   │   │       │
│   │   │       └── umair/
│   │   │           ├── App.java
│   │   │           ├── CategoryOperations.java
│   │   │           ├── DbConnection.java
│   │   │           ├── ProductsOperations.java
│   │   │           └── SupplierOperations.java
│   │   │
│   │   └── resources/
│   │       └── hibernate.cfg.xml
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

---

## 🎓 Learning Outcomes

This project demonstrates understanding of:

- ✅ **JPA Annotations**: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@ManyToOne`, `@JoinColumn`
- ✅ **Hibernate Configuration**: XML-based configuration
- ✅ **Session Management**: Creating and managing Hibernate sessions
- ✅ **Transaction Handling**: Begin, commit, and rollback operations
- ✅ **HQL (Hibernate Query Language)**: Custom queries for data retrieval
- ✅ **Entity Relationships**: Implementing many-to-one associations
- ✅ **CRUD Operations**: Complete implementation with persistent entities

---

## 🔧 Configuration

### Hibernate Configuration (`hibernate.cfg.xml`)

```xml
<hibernate-configuration>
    <session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/inventory_db</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="hibernate.connection.password">password</property>
        
        <!-- Hibernate dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        
        <!-- Auto-create tables -->
        <property name="hibernate.hbm2ddl.auto">update</property>
        
        <!-- Show SQL in console -->
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
        
        <!-- Entity mappings -->
        <mapping class="org.practice.entities.Category"/>
        <mapping class="org.practice.entities.Product"/>
        <mapping class="org.practice.entities.Supplier"/>
    </session-factory>
</hibernate-configuration>
```

---

## 🐛 Known Issues & Future Improvements

### Current Limitations
- [ ] Session management needs refactoring (static session issue)
- [ ] Missing transaction rollback on exceptions
- [ ] No input validation
- [ ] Console-only interface

### Planned Enhancements
- [ ] Implement proper DAO pattern
- [ ] Add transaction rollback handling
- [ ] Create REST API endpoints
- [ ] Add Spring Boot integration
- [ ] Implement unit and integration tests
- [ ] Add logging framework (SLF4J + Logback)
- [ ] Create web-based UI
- [ ] Add search and filter functionality
- [ ] Implement pagination for large datasets
- [ ] Add data validation and constraints

---

## 🤝 Contributing

Contributions are welcome! Feel free to:

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. 💾 Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. 📤 Push to the branch (`git push origin feature/AmazingFeature`)
5. 🎉 Open a Pull Request

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👤 Author

**Your Name**

- GitHub: [@umairdev010](https://github.com/umairdev010)
- LinkedIn: [UMAIR TARIQ](https://linkedin.com/in/umair-tariq-84b2b83a0)

---

## 🙏 Acknowledgments

- Hibernate documentation and community
- Jakarta Persistence API specification
- PostgreSQL database team
- Everyone who has contributed to this project

---

<div align="center">

### ⭐ Star this repository if you found it helpful!

Made with ❤️ and ☕ by **Umair**

</div>