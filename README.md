# 🏫 St. Pauls Student Database Management System

A simple yet powerful Java-based console application for managing student records. This system allows you to **add**, **edit**, **delete**, **view**, and **export** student data, with persistent storage via serialization and CSV support.

---

## 🔧 Features

- ✅ Add a new student with roll number, name, class, and optional marks
- ✅ View all student records
- ✅ Search for a student by roll number
- ✅ Edit student details (roll number, name, class, marks)
- ✅ Delete student record
- ✅ Export all student records to a CSV file (`students.csv`)
- ✅ Persistent data storage using Java Serialization (`students.dat`)
- ✅ Handles invalid inputs and duplicate roll numbers gracefully

---

## 💻 Technologies Used

- Java (JDK 8+)
- Console I/O
- Object Serialization
- CSV File Writing

---

## 🗂️ Project Structure
├── Main.java # Application logic and menu interface
├── Student.java # Student data model (Serializable)
├── students.dat # Auto-generated data file for persistence
├── students.csv # Optional export file (on demand)
└── README.md # This file

## 🏠 Home Screen 
Welcome to St Pauls Students Database System

[1] View All Students
[2] Add a new student
[3] View a student by roll number
[4] Export to CSV
[5] Exit


