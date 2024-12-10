Here’s a README file specifically focused on explaining how to set up the project after downloading it from GitHub:

---

# Inventory and Travel Management System

This is a Java-based Inventory and Travel Management System built using Eclipse and MySQL. It includes functionalities such as database interaction, PDF report generation, and logging.

---

## How to Set Up the Project After Downloading

Follow these steps to set up and run the project after cloning it from GitHub:

---

### 1. Prerequisites

Ensure you have the following installed on your system:

- **Java Development Kit (JDK)** (Version 8 or higher)
- **Eclipse IDE** (for Java Developers)
- **MySQL Server** (Version 5.7 or higher)
- **MySQL Workbench** (optional, for database management)

### Required Libraries (JAR Files)

Make sure the following JAR files are included in the project directory (or download them if missing):

- `mysql-connector-java-x.x.x.jar`
- `itextpdf-x.x.x.jar`
- `pdfbox-x.x.x.jar`
- `fontbox-x.x.x.jar`
- `commons-logging-x.x.jar`

---

### 2. Clone or Download the Repository

1. Open a terminal or command prompt and run:
   ```bash
   git clone https://github.com/yourusername/Inventory-Travel-Management-System.git
   ```
2. Alternatively, download the repository as a ZIP file from GitHub and extract it.

---

### 3. Configure the Database

1. Open your MySQL client (e.g., MySQL Workbench).
2. Create a new database. For example:
   ```sql
   CREATE DATABASE inventory_travel_db;
   ```
3. Import the SQL schema provided in the project directory (`/sql/database-schema.sql`) to set up the database tables:
   - In MySQL Workbench: Open the SQL file and execute it.
   - Or use the terminal:
     ```bash
     mysql -u your_username -p inventory_travel_db < /path/to/database-schema.sql
     ```
4. Update the database connection details in the project source code (look for a file like `dbConfig.java`):
   ```java
   String url = "jdbc:mysql://localhost:3306/inventory_travel_db";
   String username = "your_username";
   String password = "your_password";
   ```

---

### 4. Import Project into Eclipse

1. Open **Eclipse IDE**.
2. Go to **File** > **Import** > **Existing Projects into Workspace**.
3. Select the extracted/cloned project folder.
4. Click **Finish**.

---

### 5. Add the JAR Dependencies

1. Locate the JAR files in the project’s `lib` folder. If they are missing, download them online.
2. Add the JAR files to the project's build path:
   - Right-click the project in the Eclipse **Package Explorer**.
   - Go to **Build Path** > **Add External Archives**.
   - Select all required JAR files and click **OK**.

---

### 6. Run the Application

1. In Eclipse, locate the login file (e.g., `login.java`).
2. Right-click the file and select **Run As** > **Java Application**.
3. The application will start, and you can interact with the system through the interface.

---

## Troubleshooting

- **Database Connection Error**: Verify the database credentials in the code and ensure MySQL server is running.
- **Missing JAR Files**: Download the required JAR files and add them to the build path.
- **Eclipse Build Errors**: Clean and rebuild the project:
  - Go to **Project** > **Clean** > Select your project > **OK**.

---

## Project Features

- Inventory management with CRUD operations.
- Travel management functionality.
- Automatic PDF report generation.
- Logging system for tracking application events.

---

## Contact

For assistance, please contact:

- **Name**: FI Pranto 
- **Email**: fipranto9001@gmail.com
- **GitHub**: FI Pranto
